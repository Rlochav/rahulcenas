<%@include file="../common/taglibs.jsp"%>
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css"> -->
<link rel="stylesheet" href="<c:url value="../static/css/fonts/fontawesome/font-awesome.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/froala_editor.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/froala_style.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/plugins/code_view.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/plugins/image_manager.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/plugins/image.css"/>" />
<link rel="stylesheet" href="<c:url value="../static/editor/css/plugins/table.css"/>" />
<%-- <link rel="stylesheet" href="<c:url value="../static/editor/css/plugins/video.css"/>" /> --%>
<!-- link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css"> -->
<link rel="stylesheet" href="<c:url value="../static/editor/css/codemirror.min.css"/>" />

<style>
div#editor {
	width: 100%;
	height: 100%;
	margin: auto;
	text-align: left;
}
</style>

<div>
	<div class="row">
		<div class="col-md-12">
			<div id="editor">
				<textarea id='edit' style="margin-top: 30px;" placeholder="Type some text">
		        <h1>Textarea</h1>
		        <p>The editor can also be initialized on a textarea.</p>
			</textarea>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="col-md-2">
			<input type="button" class="btn-blue" value="Save" />
		</div>
	</div>
</div>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js"></script> -->
<script type="text/javascript" src="<c:url value='../static/editor/js/codemirror.min.js' />"></script>
<!-- <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js"></script> -->

<script type="text/javascript" src="<c:url value='../static/editor/js/froala_editor.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/align.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/code_beautifier.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/code_view.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/draggable.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/image.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/image_manager.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/link.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/lists.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/paragraph_format.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/paragraph_style.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/table.min.js' />"></script>
<%-- <script type="text/javascript" src="<c:url value='../static/editor/js/plugins/video.min.js' />"></script> --%>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/url.min.js' />"></script>
<script type="text/javascript" src="<c:url value='../static/editor/js/plugins/entities.min.js' />"></script>

<script>
	$(function() {
		$('#edit').on('froalaEditor.initialized', function(e, editor) {
			$('#edit').parents('form').on('submit', function() {
				console.log($('#edit').val());
				return false;
			})
		}).froalaEditor({
			enter : $.FroalaEditor.ENTER_P,
			placeholderText : null
		})
	});
</script>