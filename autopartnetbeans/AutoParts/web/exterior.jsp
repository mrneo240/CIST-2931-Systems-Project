<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

            <div class='main-container'>
                <h1>Exterior</h1>
                <div class="row text-center feature-imgs">
                    <h2>Feature Items</h2>
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m9880016_deals-v47.png" alt="Paris">
                            <p><strong>Full Synthetic Oil</strong></p>
                            <form action="ShoppingCartServlet" method="post">
                                <input type="hidden" name="id" value="1"/>
                                <input type="hidden" name="department" value="exterior" />
                                <p>Mobil 1 5W-20<input type="hidden" name="partName" value="Mobil 1 5W-20" /></p>
                                <p>High Mileage Advanced Full Synthetic Motor Oil, 5 qt.<input type="hidden" name="description" value="High Mileage Advanced Full Synthetic Motor Oil, 5 qt."/></p>
                                <p>$25.99<input type="hidden" name="price" value="25.99"/></p>
                                <input type="hidden" name="quantity" value="1" />
                                <p>Extra Info</p>
                            
                                <button class="btn" name="addToCart">Add to cart</button>
                            </form>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490247_prd-Alternator.jpg" alt="New York">
                            <p><strong>Alternator</strong></p>
                            <p>Extra info</p>
                            <button class="btn">Add to cart</button>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <div class="thumbnail">
                            <img src="https://www.autozone.com/images/MEDIA_ProductCatalog/m3490609_prd-Idler-Pulley.jpg" alt="San Francisco">
                            <p><strong>Pulley</strong></p>
                            <p>Extra info</p>
                            <button class="btn">Add to cart</button>
                        </div>
                    </div>
                </div>
            </div>
        <%@ include file="WEB-INF/footerTemplate.jsp" %>
    </body>
</html>