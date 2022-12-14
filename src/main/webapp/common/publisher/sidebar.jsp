<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
	.nav-list a button {
	    width: 24px;
	    height: 24px;
	    display: inline-flex;
	    justify-content: center;
	    align-items: center;
	    text-align: center;
	    margin: -2px 15px 0 7px;
	}
	
	.nav-list a button:focus {
	    outline: none;
	}
	
	.nav-list {
		overflow: hidden;
	}
</style>

<div id="sidebar" class="sidebar responsive ace-save-state">
    <script type="text/javascript">
        try{ace.settings.loadState('sidebar')}catch(e){}
    </script>
    <ul class="nav nav-list">
        <li>
            <a href='<c:url value="/publisher-book?type=list&page=1&maxPageItem=2&sortName=title&sortBy=desc" />'>
                <button class="btn btn-success">
                	<i class="fa fa-book" aria-hidden="true"></i>
            	</button>
                Quản lí sách
            </a>
        </li>
    </ul>
    <div class="sidebar-toggle sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>
</div>