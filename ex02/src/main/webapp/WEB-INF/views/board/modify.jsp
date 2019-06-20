<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<%@ include file="../includes/header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Board Modify Page</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Board Modify Page</h6>
            </div>
            <div class="card-body">
              <form role="form" action="/board/modify" method="post">
	             <div class="form-group">
	                <label>Bno</label> 
	                <input class="form-control" name="bno" 
	                value='<c:out value="${board.bno}"></c:out>' readonly="readonly"/>
	              </div>
	              <div class="form-group">
	                <label>Title</label> 
	                <input class="form-control" name="title" 
	                value='<c:out value="${board.title}"></c:out>'/>
	              </div>
	              
	              <div class="form-group">
	                <label>Test area</label> 
	                <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}" /></textarea>
	              </div>
	              
	              <div class="form-group">
	                <label>Writer</label> 
	                <input class="form-control" name="writer" 
	                value='<c:out value="${board.writer}"></c:out>' readonly="readonly"/>
	              </div>
	              
	              <div class="form-group">
	                <label>RegDate</label> 
	                <input class="form-control" name="regdate" 
	                value='<fmt:formatDate pattern="yyyy/MM/dd" 
	                  value="${board.regdate}"></fmt:formatDate>' readonly="readonly"/>
	              </div>
	              
	              <div class="form-group">
	                <label>Update Date</label> 
	                <input class="form-control" name="updateDate" 
	                value='<fmt:formatDate pattern="yyyy/MM/dd" 
	                  value="${board.updateDate}"></fmt:formatDate>' readonly="readonly"/>
	              </div>
	              
	              <button type="submit" data-oper="modify" 
	              class="btn btn-default">Modify</button>
	              <button type="submit" data-oper="remove" 
	              class="btn btn-danger">Remove</button>
	              <button type="submit" data-oper="list" 
	              class="btn btn-info">List</button>
              </form>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
        
        <script>
          $(document).ready(function(){
        	 var formObj = $('form');
        	 
        	 $('button').on('click', function(e){
        		/*
        		 * Prevent the submit()
        		 */
        		e.preventDefault();
        		
        		/*
        		 * Attribute : data-oper
        		 */
        		var operation = $(this).data('oper');
        		
        		console.log(operation);
        		
        		if(operation === 'remove'){
        			formObj.attr('action', '/board/remove');
        		}else if(operation === 'list'){
					formObj.attr('action', '/board/list').attr('method', 'get');
					formObj.empty();
        		}
        		formObj.submit();
        		
        	 });
          });
        </script>
<%@ include file="../includes/footer.jsp" %>