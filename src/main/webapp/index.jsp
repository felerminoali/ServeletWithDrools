<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <form action="/ServeltWithDrools/Prediction" method="post">
            nAssigment:
            <select name="nAssigment">
                <option value="low">low</option>
                 <option value="medium">medium</option>
                <option value="high">high</option>
            </select>
            
            
            nQuiz:
            <select name="nQuizz">
                <option value="low">low</option>
                 <option value="medium">medium</option>
                <option value="high">high</option>
            </select>
            
            
            <input type="submit" value="submit"/>
            
        </form>
        
    </body>
</html>
