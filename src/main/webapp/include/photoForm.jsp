<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/photoInsert" method="post" enctype="multipart/form-data">
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">등록</h4>
				</div>
				<div class="modal-body">
					<input type="hidden" name="atch_divsion" value="photo" class="form-control" >
					<div class="form-group">
						<label>제목</label>
						<input type="text" name="pt_title" class="form-control" >
					</div>
					<div class="form-group">
						<label>코멘트</label>
						<textarea id="summernote" name="pt_content" class="form-control"></textarea>
						<script>
							$(document).ready(function() {
								$('#summernote').summernote({
									  height: 120,
									  toolbar: false,
									  background-color:none,
									  disableResizeEditor: true
									});
							});
						</script>
					</div>
					<div class="file_area" >
					<button type="button" id="id_btn_new_file" class="form-control">추가</button>
						<div class="form-inline">
							<input type="file" name="attachFiles" class="form-control">
							<button type="button" class="btn_delete btn btn-sm">삭제</button>
						</div>
					</div>					
					<script type="text/javascript">
						// 파일 추가 버튼 
						$("#id_btn_new_file").click(function(){			
							$(".file_area").append("<div class='form-inline'>"
									     + "<input type='file' name='attachFiles' class='form-control'>"
								       	 + "<button type='button' class='btn_delete btn btn-sm'>삭제</button>"
								         + "</div>");	
						});
						
						// 파일 삭제 
						$('.file_area').on('click','.btn_delete', function(){
							$(this).closest('div').remove();
						});						
					</script>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="submit" class="btn btn-primary">확인</button>
				</div>
			</div>
		</div>
	</div>
</form>
