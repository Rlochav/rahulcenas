<%@include file="../common/taglibs.jsp"%>
<div class="btn-group btn-group-justified mar-bot-10 rel-pos" role="group" aria-label="">
	<div class="btn-group" role="group">
		<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown" role="button"
			aria-expanded="false"> User Menu <span class="caret"></span>
		</a>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">MY COMPANIES</a></li>
			<li><a href="openProductManagement">MY PRODUCTS</a></li>
			<li><a href="openCategoryMaster">Category Master</a></li>
			<li><a href="openSubCategoryMaster">Sub-Category Master</a></li>
			<li><a href="#">MY PROFESSION, CV &amp; PROFILE</a></li>
			<li><a href="#">FAMILY &amp; FRIENDS</a></li>
			<li><a href="#">PLAY BUZZ</a></li>
			<li><a href="#" data-toggle="modal" data-target="#createGroupModal">Create Group</a></li>
			<li><a href="#">MY NOTES</a></li>
			<li><a href="#">MY REPORTS &amp; PROJECTS</a></li>
			<li><a href="#">DEFINE YOUR WANTS &amp; NEEDS</a></li>
			<li><a href="#">C-Mail</a></li>
			<li><a href="#">1-Inbox</a></li>
			<li><a href="#">2-Outbox</a></li>
			<li><a href="#">3-Write new</a></li>
			<li><a href="#">4-Write to admin</a></li>
			<li><a href="#">Activity Log</a></li>
		</ul>
	</div>
	<!-- <div class="btn-group" role="group">
		<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown" role="button"
			aria-expanded="false"> News Report <span class="caret"></span>
		</a>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">YOUR MARKET REPORT ***</a></li>
			<li><a href="#">My Projects</a></li>
			<li><a href="#">BRIDGES</a></li>
			<li><a href="#">Create Page</a></li>
			<li><a href="#">Create Group</a></li>
			<li><a href="#">Manage Pages</a></li>
			<li><a href="#">NEWS</a></li>
			<li><a href="#">1-Global News</a></li>
			<li><a href="#">2-Regional News</a></li>
			<li><a href="#">3-News Archive</a></li>
			<li><a href="#">4-Events</a></li>
			<li><a href="#">Content Manager</a></li>
			<li><a href="#">Manage groups</a></li>
			<li><a href="#">1-Related Link Category</a></li>
			<li><a href="#">World Fact Book</a></li>
			<li><a href="#">Documentary Films</a></li>
		</ul>
	</div> -->
	<div class="btn-group" role="group">
		<a href="#" class="btn btn-default dropdown-toggle" data-toggle="dropdown" role="button"
			aria-expanded="false"> Shopping <span class="caret"></span>
		</a>
		<ul class="dropdown-menu" role="menu">
			<li><a href="#">MY COMPANIES</a></li>
			<li><a href="#">MY PRODUCTS</a></li>
			<li><a href="#">MY PROFESSION, CV &amp; PROFILE</a></li>
			<li><a href="#">FAMILY &amp; FRIENDS</a></li>
			<li><a href="#">PLAY BUZZ</a></li>
			<li><a href="#">MY NOTES</a></li>
			<li><a href="#">MY REPORTS &amp; PROJECTS</a></li>
			<li><a href="#">DEFINE YOUR WANTS &amp; NEEDS</a></li>
			<li><a href="#">C-Mail</a></li>
			<li><a href="#">1-Inbox</a></li>
			<li><a href="#">2-Outbox</a></li>
			<li><a href="#">3-Write new</a></li>
			<li><a href="#">4-Write to admin</a></li>
			<li><a href="#">Activity Log</a></li>
		</ul>
	</div>
</div>

<!-- Create Group Modal -->
<div id="createGroupModal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content" style="height: 370px;">
			<form name="createGroupForm" id="postImageForm">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Create New Group</h4>
				</div>
				<div class="modal-body">
					<div class="col-md-8">
						<label for="keep-login">Group Name</label><input type="text" id="firstName"
							placeholder="Group Name" />
					</div>
					<div class="col-md-8">
						<label for="keep-login">Members</label><input type="text" id="lastName" placeholder="Members" />
					</div>

					<div class="col-md-8">
						<label for="keep-login">Favorites</label><input type="checkbox" id="keep-login" /><label
							for="keep-login"> Add this group to your favorites.</label>
					</div>
					<div class="col-md-8">
						<label for="keep-login">Privacy</label>
						<ul>
							<li><input type="checkbox" id="keep-login" /> Public Anyone can see the group, its members and their posts.</li>
							<li><input type="checkbox" id="keep-login" /> Closed Anyone can find the group and see who's in it. Only members can see posts.</li>
							<li><input type="checkbox" id="keep-login" /> Secret Only members can find the group and see posts.</li>
						</ul>
					</div>
					<div class="col-md-8">
						<input type="button" value="Create" class="btn-blue" onclick="doLogin();" />
						<input type="button" value="Cancel" class="btn-blue" onclick="doLogin();" />
					</div>
				</div>
			</form>
		</div>
	</div>
</div>