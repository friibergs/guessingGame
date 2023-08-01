package com.example.guessinggame;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(true);
        Guess game = (Guess) session.getAttribute("game");

        if (game == null) {
            game = new Guess();
            session.setAttribute("game", game);
        }

        int guess = Integer.parseInt(request.getParameter("guessString"));
        String reply = game.makeGuess(guess);

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        for (String s : game.getPreviousGuesses()) {
            response.getWriter().println(s + "</br>");
        }

        response.getWriter().println("Answer: " + reply + form + "</body></html>");
    }

    String form = """
            <form method="post" action="/guess">
                <input type="text" name="guessString" size="8"/>
                <input type="submit" value="Guess"/>
            </form>
            """;

}
