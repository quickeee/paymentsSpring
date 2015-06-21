package by.academy.it.navigation.commands;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {
    String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
