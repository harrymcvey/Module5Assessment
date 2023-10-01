package controller;

import model.ComicBook;
import utility.utilityEMF;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.servlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/comicbook")
public class ComicBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if ("delete".equals(action)) {
            // Handle delete operation
            Long id = Long.valueOf(req.getParameter("id"));
            deleteComicBook(id);
            resp.sendRedirect("comicbook?action=view");
        } else if ("view".equals(action)) {
            // Handle view operation
            List<ComicBook> comicBooks = getAllComicBooks();
            req.setAttribute("comicBooks", comicBooks);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/viewComicBooks.jsp");
            dispatcher.forward(req, resp);
        } else if ("edit".equals(action)) {
            // Handle edit operation
            Long id = Long.valueOf(req.getParameter("id"));
            ComicBook comicBook = getComicBookById(id);
            req.setAttribute("comicBook", comicBook);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/editComicBook.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            // Handle create operation
            String title = req.getParameter("title");
            String issueNumber = req.getParameter("issueNumber");
            String comicCondition = req.getParameter("comicCondition");
            String publicationDateString = req.getParameter("publicationDate");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date publicationDate = formatter.parse(publicationDateString);
                createComicBook(title, issueNumber, publicationDate, comicCondition);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            resp.sendRedirect("comicbook?action=view");
        } else if ("update".equals(action)) {
            // Handle update operation
            Long id = Long.valueOf(req.getParameter("id"));
            String title = req.getParameter("title");
            String issueNumber = req.getParameter("issueNumber");
            String comicCondition = req.getParameter("comicCondition");
            String publicationDateString = req.getParameter("publicationDate");

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                java.util.Date publicationDate = formatter.parse(publicationDateString);
                updateComicBook(id, title, issueNumber, publicationDate, comicCondition);
            } catch (Exception e) {
                e.printStackTrace(); // Log appropriately in production code
            }

            resp.sendRedirect("comicbook?action=view");
        }
    }

    private void createComicBook(String title, String issueNumber, java.util.Date publicationDate, String comicCondition) {
        EntityManager em = utilityEMF.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        
        ComicBook comicBook = new ComicBook(title, issueNumber, publicationDate, comicCondition);
        em.persist(comicBook);
        
        em.getTransaction().commit();
        em.close();
    }

    private void updateComicBook(Long id, String title, String issueNumber, java.util.Date publicationDate, String comicCondition) {
        EntityManager em = utilityEMF.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        
        ComicBook comicBook = em.find(ComicBook.class, id);
        comicBook.setTitle(title);
        comicBook.setIssueNumber(issueNumber);
        comicBook.setPublicationDate(publicationDate);
        comicBook.setcomicCondition(comicCondition);

        em.getTransaction().commit();
        em.close();
    }

    private List<ComicBook> getAllComicBooks() {
        EntityManager em = utilityEMF.getEntityManagerFactory().createEntityManager();
        List<ComicBook> comicBooks = em.createQuery("SELECT c FROM ComicBook c", ComicBook.class).getResultList();
        em.close();
        return comicBooks;
    }

    private ComicBook getComicBookById(Long id) {
        EntityManager em = utilityEMF.getEntityManagerFactory().createEntityManager();
        ComicBook comicBook = em.find(ComicBook.class, id);
        em.close();
        return comicBook;
    }

    private void deleteComicBook(Long id) {
        EntityManager em = utilityEMF.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        
        ComicBook comicBook = em.find(ComicBook.class, id);
        if (comicBook != null) {
            em.remove(comicBook);
            em.getTransaction().commit();
        }
        
        em.close();
    }
}
