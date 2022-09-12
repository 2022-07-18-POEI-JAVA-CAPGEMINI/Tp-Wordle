<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wordle</title>
        <style>
            .lettre {
                font-weight: 900;
                font-size: 50px;
                display:inline-block;
                width: 50px;
                padding:5px;
                text-align: center;
            }
            .bien-place {
                 border: solid greenyellow 1px;
                 color: greenyellow;
            }
            .mal-place {
                 border: solid orange 1px;
                 color: orange;
            }
            .absent {
                 border: solid gray 1px;
                 color: gray;
            }
        </style>
    </head>
    <body>
        <h1>Wordle</h1>

        <p>Mot à deviner : ${motADeviner}</p>
        
         <p>Tentatives restantes : ${partie.nombreTentativesRestantes}</p>
        
        
            <c:forEach items="${partie.historique}" var="historiqueItem">               
                
                <c:forEach
                    var="i"
                    begin="0"
                    end="5">
                    
                        <c:if test="${historiqueItem.resultatProposition[i] eq 'BIEN_PLACE'}">
                             <span class="lettre bien-place"><c:out value="${historiqueItem.proposition[i]}"></c:out>
                             </span>
                        </c:if>
                         <c:if test="${historiqueItem.resultatProposition[i] eq 'MAL_PLACE'}">
                             <span class="lettre mal-place"><c:out value="${historiqueItem.proposition[i]}"></c:out>
                                  </span>
                        </c:if>
                        <c:if test="${historiqueItem.resultatProposition[i] eq 'ABSENT'}">
                             <span class="lettre absent"><c:out value="${historiqueItem.proposition[i]}"></c:out>
                                  </span>
                        </c:if>
                        
                    </c:forEach>
                <br/>
                  <br/>
            </c:forEach>
        
                
            <p>Faites votre proposition pour jouer:</p>
            <form action="wordle" method="POST">
                <label for="proposition">Proposition:</label>
                <input type="text" name="proposition" id="proposition" required/>
                <br />
                <input type="submit" value="Jouer" />
            </form>
        
    </body>
</html>
