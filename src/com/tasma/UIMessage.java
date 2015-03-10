/**
 * Tasma Task Manager
 */
//@author A0132763
package com.tasma;

public class UIMessage {
	public static final String COMMAND_ADD_SUCCESS = "Your task \"%s\" has been successfully created as task #%s";
	public static final String COMMAND_ADD_ARG_EMPTY = "The <add> command requires the details of the task you wish to add. Try:\n\tadd <details>";
	
	public static final String COMMAND_MARK_SUCCESS = "Your task #%s \"%s\" has been successfully marked as done.";
	public static final String COMMAND_MARK_ARG_EMPTY = "The <mark> command requires the task ID of the task you wish to mark done. Try:\n\tmark <taskId>";

	public static final String COMMAND_ARCHIVE_SUCCESS = "Your task #%s \"%s\" has been archived.";
	public static final String COMMAND_ARCHIVE_ARG_EMPTY = "The <archive> command requires the task ID of the task you wish to archive. Try:\n\tarchive <taskId>";

	public static final String COMMAND_EDIT_SUCCESS = "Your task #%s has been successfully updated.";
	public static final String COMMAND_EDIT_ARG_EMPTY = "The <edit> command requires the task ID and details of the task you wish to update with. Try:\n\tedit <taskId> <details>";

	public static final String COMMAND_SEARCH_RESULT = "%d result(s) found for \"%s\".";

	public static final String COMMAND_LIST_RESULT = "%d task(s) upcoming.";
	
	public static final String COMMAND_INVALID = "The command you have entered is invalid. Please try again.";
}
