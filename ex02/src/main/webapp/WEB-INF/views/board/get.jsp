<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<%@ include file="../includes/header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Board Read Page</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Board Read Page</h6>
            </div>
            <div class="card-body">
              <div class="form-group">
                 <label>Bno</label> 
                 <input class="form-control" name="bno" 
                 value='<c:out value="${board.bno}"></c:out>' readonly="readonly"/>
               </div>
               <div class="form-group">
                 <label>Title</label> 
                 <input class="form-control" name="title" 
                 value='<c:out value="${board.title}"></c:out>' readonly="readonly"/>
               </div>
               
               <div class="form-group">
                 <label>Test area</label> 
                 <textarea class="form-control" rows="3" name="content" 
                  readonly="readonly"><c:out value="${board.content}" /></textarea>
               </div>
               
               <div class="form-group">
                 <label>Writer</label> 
                 <input class="form-control" name="writer" 
                 value='<c:out value="${board.writer}"></c:out>' readonly="readonly"/>
               </div>
               
               <button data-oper="modify" class="btn btn-default">Modify</button>
               <button data-oper="list" class="btn btn-info">list</button>
               
               <form id="operForm" action="/board/modify" method="get">
                 <input type="hidden" id="bno" name="bno" value="<c:out value='${board.bno}' />" />
                 <input type="hidden" name="pageNum" 
                 value="<c:out value='${cri.pageNum}'></c:out>" />
                 <input type="hidden" name="amount" 
                 value="<c:out value='${cri.amount}'></c:out>" />
          		 <input type="hidden" name="type"
                 value="<c:out value='${cri.type}'></c:out>" />
          		 <input type="hidden" name="keyword"
                 value="<c:out value='${cri.keyword}'></c:out>" />
               </form>
              
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        
        <script>
          $(document).ready(function(){
        	  var operForm = $('#operForm');
        	  
        	  $('button[data-oper="modify"]').on('click', function(e){
        		  operForm.attr('action', '/board/modify').submit();
        	  });
        	  
        	  $('button[data-oper="list"]').on('click', function(e){
        		  operForm.find('#bno').remove();
        		  operForm.attr('action', '/board/list');
        		  operForm.submit();
        	  });
          });
        </script>
<%@ include file="../includes/footer.jsp" %>