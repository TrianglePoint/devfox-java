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
               
               <a data-oper="modify" class="btn btn-default" 
               href="/board/modify?bno=<c:out value='${board.bno}'></c:out>">Modify</a>
               <a data-oper="list" class="btn btn-info" 
               href="/board/list">List</a>
              
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->
<%@ include file="../includes/footer.jsp" %>