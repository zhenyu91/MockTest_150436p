package demo;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created by ZhenYu on 30/11/2016.
 */
@WebServlet(name = "ControllerServlet", urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String guess = request.getParameter("guess");
        HttpSession session = request.getSession();
        String nric = (String)session.getAttribute("nric");
        String email = (String)session.getAttribute("email");
        int guessInt = 0;
        try {
            guessInt = Integer.parseInt(guess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int result = Guess.getInstance().guess(nric, guessInt);
        request.setAttribute("answer", result);
        if (result == 0) {
            request.setAttribute("guess", guess);
            //request.getRequestDispatcher("success.jsp").forward(request,response);
            getServletContext().getRequestDispatcher("/success.jsp").forward(request, response);
        } else if (result == 999) {
            getServletContext().getRequestDispatcher("/nomore.jsp").forward(request,response);
        } else {
            if (result > 0) {
                request.setAttribute("guess", "higher");
            } else {
                request.setAttribute("guess", "lower");
            }
            getServletContext().getRequestDispatcher("/tryagain.jsp").forward(request, response);
        }
    }
}