<%-- 
    Document   : faq
    Created on : Oct 17, 2018, 2:04:03 PM
    Author     : Michelle (Boobin) Choi
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page trimDirectiveWhitespaces="true"%>
<%@ include file="WEB-INF/headerTemplate.jsp" %>

<div class='main-container'>
    <button onclick="topFunction()" id="myBtn" class="btn btn-info btn-lg" title="Go to top">Top</button>
    <script>
        window.onscroll = function () {
            scrollFunction()
        };

        function scrollFunction() {
            if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
                document.getElementById("myBtn").style.display = "block";
            } else {
                document.getElementById("myBtn").style.display = "none";
            }
        }

        function topFunction() {
            document.body.scrollTop = 0;
            document.documentElement.scrollTop = 0;
        }
    </script>
    <div class="row form-group">
        <div class="container">
            <div class="row">
                <div class="col-md-2 col-sm-2 col-xs-12" style="position:fixed;">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center">
                            <h2>Article Contents</h2>
                        </div>
                        <div class="panel-body faq_nav">
                            <ul>
                                <a href="#ship_store"><li>Buy Online, Pick Up In Store</li></a>
                                <a href="#special_orders"><li>Special Orders</li></a>
                                <a href="#ship_home"><li>Buy Online, Ship to Home</li></a>
                                <a href="#orders"><li>Express Car Parts Orders</li></a>
                                <a href="#shipping_delivery"><li>Shipping & Delivery</li></a>
                                <a href="#creditCard"><li>Credit Card Processing</li></a>
                                <a href="#cancellation"><li>Order Cancellation</li></a>
                                <a href="#missing_orders"><li>Missing Orders</li></a>
                                <a href="#returns"><li>Returns & Exchanges</li></a>
                                <a href="#information"><li>Express Car Parts Information</li></a>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-9 col-sm-9 col-xs-12" style="float:right;">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-default">
                        <div class="panel-heading text-center">
                            <h2>Online Shopping at Express Cart Parts</h2>
                        </div>
                        <div class="panel-body">
                            <div class="faq_main">

                                <p>Express Car Parts offers two great options for your online purchase: pick your order up at a store near you OR have it shipped to you.</p>

                                <article id="ship_store" class="faq_article">
                                    <h3>Buy Online, Pick Up In Store</h3>
                                    <p>At Express Car Parts, you can view the stock status at stores near you and make your purchase online. Then, all you have to do is stop by and pick up your order at the store.</p>
                                    <ul>
                                        <li>Find the store near you that is stocking the item(s) you need</li>
                                        <li>Select the item(s) you’d like to purchase</li>
                                        <li>Choose the “Pick up in Store” option</li>
                                        <li>Add the item(s) to your cart</li>
                                        <li>Review your order and check out</li>
                                        <li>You will receive a confirmation email (this is not a receipt; this does not mean your order is ready to pick up—we’re letting you know we’re processing your order)</li>
                                        <li>You will receive a second email a short time later indicating your order is ready to pick up—the amount of time will vary; please wait until you’ve received this to come pick up your order</li>
                                        <li>Please bring the following with you to the store:</li>
                                        <li>Your device showing the ready-to-pick-up email OR a copy of the ready-to-pick-up email</li>
                                        <li>The card(s) used to pay for the order</li>
                                        <li>A valid photo ID, such as your driver’s license</li>
                                    </ul>
                                    <p>Only in-store items are available for online purchase and in-store pickup.(Warehouse items are not eligible for online order and in-store pickup.)</p>
                                    <p>We will hold your order for three days, after which it may be cancelled and refunded.</p>
                                    <p>Important Note</p>
                                    <p>In the event that the cardholder is unable to personally pick up the order (such as the order being placed at a store in another state for a family member), please call Online Order Support at 1.888.123.0000 to make the necessary arrangements.</p>
                                </article>

                                <article id="special_orders" class="faq_article">
                                    <h3>Special Orders</h3>
                                    <p>If you’re looking for an item that’s not in stock, your local Express Car Parts store can help. Just call or stop by for more details.</p>
                                </article>

                                <article id="ship_home" class="faq_article">
                                    <h3>Buy Online, Ship to Home</h3>
                                    <p>Once you’ve selected a store and the items you’re looking for, you can choose the “Ship to Home” option to have your order delivered to you.</p>
                                    <ul>
                                        <li>Find the store near you that is stocking the item(s) you need</li>
                                        <li>Select the item(s) you’d like to purchase</li>
                                        <li>Choose the “Ship to Home” option</li>
                                        <li>Add the item(s) to your cart</li>
                                        <li>Review your order and check out</li>
                                        <li>On the Delivery page, you’ll enter your address and select a shipping method*</li>
                                        <li>You will receive a confirmation email letting you know we’re processing your order</li>
                                    </ul>
                                    <p>You’ll be able to monitor the status of any item(s) purchased for delivery by logging into your account and selecting the “My Orders” tab. A link to track your order is also included in your confirmation email.</p>
                                    <p>For more information on Ship to Home orders, please see our section on Shipping & Delivery.</p>
                                    <p>*Each item you add to your cart will give you a choice of available shipping options, which may include Standard Ground, Two Day or Next Day.</p>
                                </article>

                                <article id="orders" class="faq_article">
                                    <h3>Express Car Parts Orders</h3>
                                    <p><b>Frequently Asked Questions About Express Car Parts Orders</b></p>
                                    <p><strong>What do I do if I receive a processing error for my payment?</strong></p>
                                    <p>Failed Authorizations and Payment Declines</p>
                                    <p>You may need to contact your financial institution for assistance on declined payments. You are always welcome to submit an alternate payment method for your order if you are unable to resolve the payment issue with your financial institution in a timely manner.</p>
                                    <p>Common reasons for failed payment authorizations:</p>
                                    <ul>
                                        <li>The billing address you are providing does not match what your financial institution has on file.</li>
                                        <li>The security code CID/CVV is incorrect for the credit card number you have provided.</li>
                                        <li>All lines to your financial institution could be temporarily busy.</li>
                                        <li>Daily withdrawal or purchase limits.</li>
                                        <li>Insufficient funds.</li>
                                    </ul>
                                    <p><em>Note: Some financial institutions have been known to hold these authorizations for 7-10 business days.</em></p>
                                    <p><strong>Why does my order say “Error. There was a problem processing your payment. Please try again”?</strong></p>
                                    <p>At the time an order is placed, our system first verifies the funds are available, then validates the credit card information you submitted. If the entered information fails to coincide with what is on file for the credit card, our security system will deny the order and credit the amount back. The verified funds will be “Pre-Auth” on your account. Your credit card company/bank will usually release the funds back to your account within the same day. The pending dollar will drop off your account usually in a couple days. Regrettably, we have no access to the reason why the credit card information doesn't coincide.</p>
                                    <p>Please make sure the following information is entered correctly on the checkout page when placing the order:</p>
                                    <ul>
                                        <li>Credit or Debit Card number.</li>
                                        <li>The card expiration date.</li>
                                        <li>The CID number.</li>
                                        <li>The exact Name and Billing Address as it is printed on your Credit Card statement.<br> <br> </li>
                                    </ul>
                                    <p>Errors in any of this information will cause the order to be rejected.</p>
                                    <p>Please contact your credit card institution for information.</p>
                                    <p><strong>Why do you need my phone number during checkout?</strong></p>
                                    <p>Express Car Parts uses your phone number as a reference for all warranties. Your phone number used during checkout will not be released to any third parties. For more information, please visit our <a target="_blank" href="/legal-policies#privacy-policy">Privacy Policy</a> page.</p>
                                    <p><strong>Why might I pay more or less at my local store than the online total check out amount?</strong></p>

                                    <p>Because actual pricing and sales tax costs vary slightly from location to location and because of local specials and discounts, your final check out total shown here may not reflect the actual amount you will pay when you check out at your local store. Rest assured, we are doing our best to be accurate. However, when shopping at one of our stores, it will be necessary for you to pay the price determined at the time you check out.</p>
                                    <p><strong>Can I pay by check? Can I order items COD?</strong></p>

                                    <p>The Express Car Parts Online Store only accepts major credit cards and Express Car Parts gift cards as payment. Any of our 4800 store locations will also gladly accept cash and checks.</p>
                                    <p><strong>Why am I being charged sales tax?</strong></p>

                                    <p>The Express Car Parts is required to collect taxes in all states where we have a physical presence. We are also required to calculate your taxes based on where your order is being shipped to. As a result, if we have a physical presence in the state we are shipping your order to, we are required by law to charge all applicable state and local taxes.</p>
                                </article>

                                <article id="shipping_delivery" class="faq_article">
                                    <h3>Shipping &amp; Delivery</h3>
                                    <p>Most orders placed at Express Car Parts process within 2 days. All items are shipped via UPS from the nearest stocking Distribution Center.Items are not available to ship from local stores. The following options may be available (all UPS): Standard Ground, Two Day or Next Day; you’ll be given all available shipping options at checkout. It is possible&mdash;depending on the size of your order&mdash;that your items could come in multiple packages from multiple locations.</p>
                                    <p><b>Frequently Asked Questions on Shipping &amp; Delivery:</b></p>

                                    <h4>Shipping Rates</h4>
                                    <p><strong>Can I qualify for free shipping?</strong></p>
                                    <p>You can qualify for free ground shipping on most orders totaling $<span class="js-free-shipping-threshold"></span> or more (excluding any core charges). If an item does not qualify for free shipping, you will be notified at or before checkout. None of the following qualify for free shipping:</p>
                                    <ul>
                                        <li>Oversized items or items requiring special handling</li>
                                        <li>Shipments to Alaska or Hawaii</li>
                                        <li>Items shipped via UPS Two Day or Next Day</li>
                                        <li>Items that are not in stock</li>
                                    </ul>
                                    <p>We do not ship to any locations outside the 50 United States. Express Car Parts reserves the right to modify or end this offer at any time without notice.</p>

                                    <h4>Addresses</h4>
                                    <p><strong>Can I have my order shipped to a location outside of the United States?</strong></p>
                                    <p>Express Car Parts ships only to locations within the 50 United States. Shipment to international addresses, including Canada and Mexico, is not offered.</p>
                                    <p><strong>Can I have my order shipped to a different address than my home address?</strong></p>
                                    <p>Yes, you can enter a different shipping address during the checkout process.</p>
                                    <p><strong>Can I have parts shipped to an APO or FPO address?</strong></p>
                                    <p>Express Car Parts does not currently offer shipping&mdash; by USPS or any other carriers&mdash; to APO or FPO addresses or to any of the U.S Territories. We are keeping an eye on requests for this service for future consideration. Please check back with us.</p>
                                    <p><strong>Can I have parts delivered to a PO Box?</strong></p>
                                    <p>Currently, all shipping from Express Car Part is done through UPS, which does not deliver to Post Office boxes. A physical street address is required.</p>

                                    <h4>Delivery Times</h4>
                                    <p><strong>When will I get my order?</strong></p>
                                    <p>All delivery dates shown on the site are estimates; it is not possible to guarantee a delivery date. Generally, when an order is shipped via Standard UPS Ground, your order will arrive in 3 to 5 days (excluding weekends and holidays). Estimated delivery dates will be available on the checkout page. The email you received confirming your shipment contains a link to tracking.</p>
                                    <p><strong>Will I have my choice of Standard, Two Day or Next Day shipping for every item I purchase?</strong></p>
                                    <p>No&mdash; every item you purchase for delivery will show you all available shipping options, but it is possible that not all options will be available, depending on the item.</p>

                                    <h4>Tracking a Package</h4>
                                    <p><strong>Can I see where my package is while it’s on the way?</strong></p>
                                    <p>A link for package tracking is included in the email confirming the shipment of your order. You may also log in at ExpressCar Parts, select “My Account” and then “My Orders” to track a specific shipment.</p>
                                </article>    

                                <article id="creditCard" class="faq_article">
                                    <h3>Credit Card Processing</h3>
                                    <p><strong>How is my credit card processed when I order online?</strong></p>
                                    <p>At the time you place your order, our system will validate the credit card information you provided and verify that funds are available in your account. If the information you provided during checkout fails to coincide with the information on file for the credit card you used, our security system will deny your order. If the information you provided is accurate, your credit card will be charged for the full amount of your order on the day that your order is shipped.</p>
                                    <p><strong>What is a Card Identification Number (CID)?</strong></p>
                                    <p>In our ongoing effort to provide a secure shopping experience, we require your CID from your credit card each time you order from us. We do not store this security number. The CID for Visa, MasterCard, and Discover cards is a 3-digit number located on the back of the card, printed on the signature panel immediately following your account number. The CID for American Express cards is a 4-digit number located on the front of the card, printed just above your account number.</p>
                                    <p><strong>Can I use an international credit card for my Express Car Parts purchase?</strong></p>
                                    <p>International credit cards are not accepted on ExpressCar Parts. We accept Visa, MasterCard, Discover and American Express cards issued by U.S. banks or credit card companies with U.S. billing addresses.</p>
                                </article>

                                <article id="cancellation" class="faq_article">
                                    <h3>Order Cancellation</h3>
                                    <p><strong>Is it possible for me to cancel my online order?</strong></p>
                                    <p>If for some reason you need to cancel an order made on ExpressCar Parts, please contact Online Order Support directly at 1.888.123.0000, option 1.</p>
                                    <p>Pick Up In Store Orders may be cancelled at any time. Ship to Home orders may be cancelled any time <strong>before</strong> the order is boxed for delivery.</p>
                                </article>

                                <article id="missing_orders" class="faq_article">
                                    <h3>Missing Orders</h3>
                                    <p><strong>My order should have been here by now. How can I be sure it isn’t lost or stolen?</strong></p>
                                    <p><strong>Missing orders, missing parts, wrong parts or damaged packages must be reported to Express Car Parts within 48 hours of UPS confirming that the order was delivered.</strong></p>
                                    <p>First, check the UPS tracking number included in your confirmation email. You can also log into ExpressCar Parts, select “My Account” and then “My Orders” for this information. Once you have confirmed the delivery was completed by UPS, check with everyone in your household to make sure someone else didn’t receive the package. Look behind any bushes or furniture near the delivery location, and if necessary, check with your neighbors.</p>
                                    <p>If you still haven’t located the package, filing a stolen property report with your local police is a good idea. You may want to check with your insurance company about renters’ or home owners’ coverage.</p>
                                    <p>Next, contact Express Car Parts/Online Order Support by phone, chat or email. We will note on the order record that the delivered package is missing or possibly stolen from the location and file a Missing Package Report on your behalf with UPS. This does not guarantee your order will be replaced or refunded. Please understand: Express Car Parts is not responsible to replace or refund any order that shows to be delivered in UPS tracking. The security of deliveries becomes the responsibility of the customer once the order reaches the addressed location. Neither UPS nor Express Car Parts is responsible to replace product that is missing or stolen from the delivery location. Only after UPS investigates and accepts the claim as mis-delivered can a refund be considered. If UPS validates the delivery was completed as indicated, no reimbursement will be issued.</p>
                                </article>

                                <article id="returns" class="faq_article">
                                    <h3>Returns &amp; Exchanges</h3>
                                    <p><strong>Got an item you need to bring back? Here’s what you need to know.</strong></p>
                                    <p><strong>New Merchandise</strong></p>
                                    <p>Both online and in-store purchases can be returned to your local store. There is no time limit for a New return as long as you have your original purchase receipt&mdash;but we do ask you make your return as soon as possible. Here’s what you’ll need:</p>
                                    <ul>
                                        <li>The item must be in its original packaging</li>
                                        <li>Must include all original materials supplied with the product</li>
                                        <li>Must be unopened and uninstalled</li>
                                    </ul>
                                    <p><strong>Online Orders (Sending Returns to the Online Store&mdash;ExpressCar Parts):*</strong></p>
                                    <p>Remember, even items purchased online can be returned to any Express Car Parts store. You’ll still need to follow the return guidelines above when sending in a New return. Please keep the following in mind:</p>
                                    <ul>
                                        <li>Customers are responsible for all shipping costs*</li>
                                        <li>Returns sent COD (Cash on Delivery) will not be accepted</li>
                                        <li>If you return an item you didn’t buy from us, you’ll have to pay shipping to have it sent back to you </li>
                                        <li>You must obtain an RMA (Return Material Authorization) from ExpressCar Parts</li>
                                        <li>Sign in or create account </li>
                                        <li>Select “My Orders” tab</li>
                                        <li>Select the “Return Items” option</li>
                                    </ul>
                                    <p>*shipping charges are non-refundable</p>
                                    <p><strong>Core Returns </strong></p>
                                    <p>You may return cores to any Express Car Parts store (even if the original product purchase was online); you must have the packing slip or shipping confirmation email. Cores may also be returned directly to ExpressCar Parts (customer pays shipping).</p>
                                    <p>To send a core back, you must obtain an RMA (Return Material Authorization) from ExpressCar Parts. If you need assistance, call Online Order Support at 1.888.327.7153, option 1.</p>
                                    <ul>
                                        <li>Sign in or create account </li>
                                        <li>Select “My Orders” tab</li>
                                        <li>Select the “Return Items” option</li>
                                    </ul>
                                    <p><strong>New Batteries</strong></p>
                                    <p>Batteries cannot be returned once installed for any length of time (unless tested at an Express Car Parts store and found to be defective)</p>
                                    <p>“Dry” stored batteries are not returnable once opened <b>or</b> acid in the kit is added to the battery</p>
                                    <p>If possible, making a return at your local Express Car Parts store at your convenience is the quickest, easiest and most economical solution.</p>
                                    <p>If you are unable to make your return to an Express Car Parts store, you may mail your return to ExpressCar Parts. If it is approved for a refund, the amount of the item will be credited back to the gift/credit/debit card originally used to purchase the product (usually within 1 to 3 business days after the product is received by the online store). We recommend shipping with a carrier that offers tracking, insurance and delivery confirmation (such as UPS or FedEx). If you use USPS mail, we require that you request USPS to obtain a signature at delivery time.</p>
                                    <p>If you send us an item for refund that we don’t approve as a return, you will be required to pay shipping on that item in order to receive it back.</p>
                                    <p>**For returns involving warranties or defects, products shipped in error, or products damaged in shipping, please send us an email via the Online Ordering section of the Contact Us page, or you may contact us toll free at 1.888.327.7153, option 1. Please be able to specify the order number for the product you wish to return and be able to provide a brief description of the nature of the problem with the product. An Online Order Support agent will assist you with the return and provide a Return Code RMA and prepaid return shipping label (if applicable) via e-mail.</p>
                                    <p>All returned merchandise is subject to inspection and approval prior to credit being issued. Retail store credit will not be given; we will only refund the card/account used for the purchase, so please retain gift cards until your entire transaction is complete. Clearance items, custom-made or modified parts are not eligible for return.<br></p>
                                </article>

                                <article id="information" class="faq_article">
                                    <h3>Express Car Parts Information</h3>
                                    <h4>Buying the Right Part</h4>
                                    <p>At Express Car Parts, we are concerned about your safety and want to prevent damage to your vehicle. With today's vehicles, purchasing and installing auto parts can be a complicated process. We understand this. That is why we have Professional Parts People and powerful search software to help you through the process. While we always do our best to ensure we provide you with accurate and up-to-date part information, human and/or software errors sometimes occur. These errors may cause an incorrect part to be displayed as the result of a part search.</p>
                                    <p>For these reasons and more, you must always do, at a minimum, the following 4 steps to help ensure that the part you buy is the correct one for your repair project.</p>
                                    <ol>
                                        <li>Make sure ALL of the vehicle information you provide is correct. This includes the vehicles you define and any questions that you may answer on our web site. Read and understand ALL of the informational checkmarks listed with each part. If there are codes or statements that do not match your vehicle, do not buy the part. If there is information you do not understand, contact one of our team members at your local store and find out what it means.</li>
                                        <li>If you have no local store, please feel free to contact one of our Customer Service team members. See our Contact Us (URL /contact-us) page for details on contacting Customer Service.</li>
                                        <li>Compare Web site photos with your old part. If photos of the item you are purchasing are available on our Web site and if they are not labeled as "representative" photos, compare them with the old part and make sure they match.</li>
                                        <li>When the part arrives compare it with the old part. If for any reason it does not appear to be the correct part, contact us to confirm that it is the correct part before installing it</li>
                                    </ol>
                                    <p>Using these steps will assist you in selecting the correct part to get the job done right. Remember that, as with any large, powerful and complex system, failure to select the right part for your vehicle may result in damage to your vehicle, serious injury or death. Do not risk it. If in doubt, get answers from one of our friendly and helpful Express Car Parts team members.</p>

                                    <h4>What is a core charge?</h4>
                                    <p>Some products have a core charge associated with them. A core is some portion of a part that can be recycled or reused by the manufacturer. Doing this saves the manufacturer money and helps our environment. For this reason a product with a core has an additional charge associated with it. If the old part is returned in reusable condition (either to one of our stores or shipped back to our online store), the core charge will be credited back to the card used to purchase the part. Please note: It is the customer's responsibility to pay any shipping cost associated with shipping a core back to the Express Car Parts Online Store. There is no shipping charge if you take the old part back to one of our stores.</p>

                                    <h4>Why can't I find replacement parts for my early model vehicle online?</h4>
                                    <p>Availability of electronic catalog data for early model vehicles is limited at this time. Express Car Parts strives to provide the most up-to-date and accurate listings possible. Please visit your local Express Car Parts store for more detailed part inquiries.</p>

                                    <h4>Why aren't there images and descriptions for some of your parts?</h4>
                                    <p>Express Car Parts is constantly working with our vendors to improve your online shopping experience by providing more detailed descriptions and images for our products. Please call or visit your local Express Car Parts store for more details.</p>

                                    <h4>What browsers does your site support?</h4>
                                    <p>Our site works on all current browsers in Windows 7+, Mac OSX, Android, Windows Mobile specifically:<br> - Internet Explorer 11 (Users are recommended to update to the latest version of IE for security purposes.)<br> - Latest version of Firefox and the latest Firefox ESR (selecting About Firefox from the help menu will indicate if it is the Firefox ESR.)<br> - Latest version of Chrome.<br> - Latest version of Safari for desktop and mobile.<br> - Latest version of Android browsers.</p>

                                    <h4>Why can't I find replacement parts for my motorcycle, ATV, or watercraft online?</h4>
                                    <p>Unfortunately, Express Car Parts does not have electronic catalog data for motorcycle, ATV, or watercraft at this time. Please contact your local store and ask a Professional Parts Person to check the paper catalogs for your application.</p>

                                    <h4>Installation Instructions</h4>
                                    <p>Because of the variety and complexity of vehicles available today, we are unable to provide detailed installation instructions for your part. We do have vehicle repair manuals available for purchase and online services to assist you. Additionally, our manufacturers sometimes provide limited instructions with the parts we sell. We highly recommend that you take advantage of these resources when working on your vehicle. If you are ever unsure of the correct or safest way to install a part, we recommend you seek help from a licensed, professional installer.</p>
                                    <p>Failure to install a part correctly may result in damage to your vehicle, serious injury or death. Do not risk it. If you do not know how to install a part, get answers from a licensed, professional installer or have them install the part for you.</p>
                                </article>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="WEB-INF/footerTemplate.jsp" %>
