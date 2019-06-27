<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<%@ include file="../includes/header.jsp" %>
        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Tables</h1>
          
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <span class="m-0 font-weight-bold text-primary">Board List Page</span>
              
              <!-- 'pull-right' is change to 'fa-pull-right' (all.min.css)-->
              <button id="regBtn" type="button" class="btn btn-xs fa-pull-right">
                Register New Board
              </button>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                      <th>수정일</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${list}" var="board">
                  <tr>
                    <td><c:out value="${board.bno}" /></td>
                    <td>
                      <a class="move" href="<c:out value='${board.bno}'></c:out>">
                        <c:out value="${board.title}" />
                      </a>
                    </td>
                    <td><c:out value="${board.writer}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd" 
                    value="${board.regdate}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MM-dd"
                    value="${board.updateDate}" /></td>
                  </tr>
                  </c:forEach>
                  </tbody>
                </table>
                
                <form id="searchForm" action="/board/list" method="get">
                  <select name="type">
                    <option value="">---</option>
                    <option value="T" 
                     <c:out value="${pageMaker.cri.type eq 'T' ? 'selected' : ''}" />>제목</option>
                    <option value="C" 
                     <c:out value="${pageMaker.cri.type eq 'C' ? 'selected' : ''}" />>내용</option>
                    <option value="W" 
                     <c:out value="${pageMaker.cri.type eq 'W' ? 'selected' : ''}" />>작성자</option>
                    <option value="TC" 
                     <c:out value="${pageMaker.cri.type eq 'TC' ? 'selected' : ''}" />>제목 + 내용</option>
                    <option value="TW" 
                     <c:out value="${pageMaker.cri.type eq 'TW' ? 'selected' : ''}" />>제목 + 작성자</option>
                    <option value="TWC" 
                     <c:out value="${pageMaker.cri.type eq 'TWC' ? 'selected' : ''}" />>제목 + 작성자 + 내용</option>
                  </select>
                  <input type="text" name="keyword" 
                  value="<c:out value='${pageMaker.cri.keyword}'></c:out>"/>
                  <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" />
                  <input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
                  <button class="btn btn-default">Search</button>
                </form>
                
                <div class="fa-pull-right">
                  <ul class="pagination">
                    <c:if test="${pageMaker.prev}">
                      <li class="paginate_button previous page-item">
                        <a href="<c:out value='${pageMaker.startPage-1}'></c:out>" class="page-link">Previous</a>
                      </li>
                    </c:if>
                    
                    <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                      <li class="paginate_button page-item 
                      ${pageMaker.cri.pageNum == num ? 'active' : ''}">
                        <a href="<c:out value='${num}'></c:out>" class="page-link">${num}</a>
                      </li>
                    </c:forEach>
                    
                    <c:if test="${pageMaker.next}">
                      <li class="paginate_button next page-item">
                        <a href="<c:out value='${pageMaker.endPage+1}'></c:out>" class="page-link">Next</a>
                      </li>
                    </c:if>
                  </ul>
                  <!-- End pagination -->
                </div>

                <!-- Modal -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                 aria-labelledby="myModalLabel" aria-hidden="true">
                  <div class="modal-dialog">
                    <div class="modal-content">
                      <div class="modal-header">
                      <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                      <button type="button" class="close" data-dismiss="modal" 
                         aria-hidden="true">&times;</button>
                      </div>
                      <div class="modal-body">처리 끝!</div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-default"
                         data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">
                          Save changes
                        </button>
                      </div>
                    </div>
                    <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
                </div>
                <!-- /.modal -->
                
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.card-body -->
          </div>
        </div>
        <!-- /.container-fluid -->
        
        <form id="actionForm" action="/board/list" method="get">
          <input type="hidden" name="pageNum" 
          value="<c:out value='${pageMaker.cri.pageNum}'></c:out>" />
          <input type="hidden" name="amount" 
          value="<c:out value='${pageMaker.cri.amount}'></c:out>" />
          <input type="hidden" name="type"
          value="<c:out value='${pageMaker.cri.type}'></c:out>" />
          <input type="hidden" name="keyword"
          value="<c:out value='${pageMaker.cri.keyword}'></c:out>" />
        </form>
        
        <script>
          $(document).ready(function(){
        	  var result = '<c:out value="${result}" />';

        	  if(shouldShowModal(result)){
          	      $('#myModal').modal('show');
        	  }
        	  
        	  history.replaceState({}, null, null);
        	  
        	  function shouldShowModal(result){
        		  if(result === '' || history.state){
        			  return false;
        		  }
        		  
        		  if(parseInt(result) > 0){
        			  setModalHtml(result);
        		  }
        		  return true;
        	  }
        	  
        	  function setModalHtml(result){
        		  $('.modal-body').html('게시글 ' + parseInt(result) + '번이 등록됨');
        	  }
        	  
        	  $('#regBtn').on('click', function(){
        		  self.location = '/board/register';
        	  });
        	  
        	  var actionForm = $('#actionForm');
        	  
        	  $('.paginate_button a').on('click', function(e){
        		 e.preventDefault();
        		 
        		 console.log('click');
        		 
        		 actionForm.find('input[name="pageNum"]').val($(this).attr('href'));
        		 actionForm.submit();
        	  });
        	  
        	  $('.move').on('click', function(e){
        		  e.preventDefault();
        		  
        		  var input = $('<input />');
        		  input.attr('type', 'hidden');
        		  input.attr('name', 'bno');
        		  input.attr('value', $(this).attr('href'));
        		  
        		  actionForm.append(input);
        		  actionForm.attr('action', '/board/get');
        		  actionForm.submit();
        	  });
        	  
        	  var searchForm = $('#searchForm');
        	  
        	  $('#searchForm button').on('click', function(e){
        		  e.preventDefault();
        		  
        		  if(!searchForm.find('option:selected').val()){
        			  alert('검색종류를 선택하세요');
        			  return false;
        		  }
        		  
        		  if(!searchForm.find('input[name="keyword"]').val()){
        			  alert('키워드를 입력하세요');
        			  return false;
        		  }
        		  
        		  searchForm.find('input[name="pageNum"]').val("1");
        		  searchForm.submit();
        	  });
          });
        </script>
<%@ include file="../includes/footer.jsp" %>