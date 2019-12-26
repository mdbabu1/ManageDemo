<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
   <!-- Required meta tags -->
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
    crossorigin="anonymous">
   <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
   <link rel="stylesheet" type="text/css" href="owner.css">
    <title>Simple Property | Property Management System</title>

</head>

<body>

  <!-- Navbar -->
      <nav id = "mainNavbar" class = "navbar bg-dark navbar-dark navbar-expand-md py-0 fixed-top">
         <div class = "container">
            <a href="home.html" class = "navbar-brand"><i class="fas fa-home"></i> Simple Property</a>
            <button class = "navbar-toggler" data-toggle = "collapse" data-target = "#navLinks">
            <span class = "navbar-toggler-icon"></span>
            </button>
            <div class = "collapse navbar-collapse" id = "navLinks">
               <ul class = "navbar-nav">
                  <li class = "nav-items">
                     <a href="home.jsp" class = "nav-link active">HOME</a>
                  </li>
                  <li class = "nav-items">
                     <a href="about.jsp" class = "nav-link">ABOUT US</a>
                  </li>
                  <li class = "nav-items">
                     <a href="contact.jsp" class = "nav-link">CONTACT US</a>
                  </li>
               </ul>
            </div>
         </div>
      </nav>

      <section class = "container">
        <div class = "row align-items-center justify-content-center my-4 py-5">
          <div class = "col-lg-4 mb-3">
                  <div class = "card">
                    <img class = "card-img-top" src="Owner/addproperty.jpg" alt = "">
                    <div class = "card-body">
                        <h5 class = "card-title"> Post Invoice</h5>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda corrupti quam magnam! Veniam, dolorum facere? Commodi, ut. Et, itaque quam!
                        </p>
                        <!-- <div> -->
                          <a href="addProperty.html" class = "btn btn-outline-success btn-md"><i class="fas fa-file-invoice"></i> Start Making Incoice</a>
                        <!-- </div> -->
                    </div>
                  </div>
               </div>
               <div class = "col-lg-4 mb-3">
                  <div class = "card">
                    <div class="container-fluid bg-light py-3">
    <form id="contact-form" method="post" action="contact.php" role="form">

        <div class="clearfix"></div>

        <div class="row">
            <div class="col-md-12">
                <div class="form-group pt-1">
                    <label for="form_message">Message *</label>
                    <textarea id="form_message" name="message" class="form-control" placeholder="Type your message *" rows="4" required="required" data-error="send a message." disabled></textarea>
                    <div class="help-block with-errors"></div>
                </div>
            </div>
            <div class="col-md-12">
                <a href="message.jsp" class = "btn btn-outline-success btn-md">Send Message</a>
            </div>
        </div>
        
    </form>
</div>
                    <div class = "card-body">
                        <h5 class = "card-title"> First pattern</h5>
                        <p class="card-text">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Assumenda corrupti quam magnam! Veniam, dolorum facere? Commodi, ut. Et, itaque quam!
                        </p>
                        <a href="ownerMessage.html" class = "btn btn-outline-success btn-md"><i class="fas fa-comment-alt"></i> Message</a>
                    </div>
                  </div>
               </div>
            </div>
      </section>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

   <script>
      $(function () {
         $(document).scroll(function(){
          var $nav = $("#mainNavbar");
          $nav.toggleClass("scrolled", $(this).scrollTop() > $nav.height());
         });
      });
   </script>

</body>
</html>