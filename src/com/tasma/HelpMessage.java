/**
 * Tasma Task Manager
 */
//@author A0132763H
package com.tasma;

/**
 * Provides storage of help messages used by the help command
 */
public final class HelpMessage {
    public static final String HELP_TEMPLATE = "Help information about '%s' command\n\n"
            + "%s\n\n"
            + "Aliases:\n%s\n\n"
            + "Angular <> and square brackets [] denote required and optional parameters respectively.";
    
    public static final String HELP_ADD = "\tadd <task details>\n\n"
            + "The 'add' command creates a new task for you based on the details"
            + " you have entered. After entering the command, the list will be"
            + " refreshed to show the new task in the list.";

    public static final String HELP_SEARCH = "\tsearch <query>\n\n"
            + "The 'search' command finds tasks in your to-do list that matches"
            + " the query string you have entered. After entering the command,"
            + " the result of the search operation will be shown in the list.";

    public static final String HELP_LIST = "\tlist [filters]\n\n"
            + "The 'list' command lists all the tasks that are upcoming in your"
            + " to-do list. The [filter] parameter is optional and can be:\n"
            + "\ttmr:\t\t\tShows all tasks due / starting tomorrow\n"
            + "\ttoday:\t\tShows all tasks due / starting today\n"
            + "\tfloating:\t\tShows all floating tasks\n"
            + "\tdone:\t\t\tShows all tasks that were done\n"
            + "\tundone:\t\tShows all tasks that were not done yet\n"
            + "\tpast:\t\t\tShows all tasks that were not done and overdue\n"
            + "\toverdue:\t\tShows all tasks that were not done and overdue, same as past\n";

    public static final String HELP_MARK = "\tmark <task number>\n\n"
            + "The 'mark' command marks a specified task as done. The <task number>"
            + " parameter is the number corresponding to the task that you want to select.";

    public static final String HELP_UNMARK = "\tunmark <task number>\n\n"
            + "The 'unmark' command marks a specified task as not done. The"
            + " <task number> parameter is the number corresponding to the task"
            + " that you want to select.";
    
    public static final String HELP_DELETE = "\tdelete <task number>\n\n"
            + "The 'delete' command deletes a specified task from the list of"
            + " tasks. The <task number> parameter is the number corresponding"
            + " to the task that you want to select.";

    public static final String HELP_EDIT = "\tedit <task number> [task details]\n\n"
            + "The 'edit' command allows you to modify details of a specific task."
            + " The <task number> parameter is the number corresponding to the"
            + " task that you want to select. In the event that the new details"
            + " of the task is not entered, the old details will be displayed"
            + " in the command box for your convenience to edit.";

    public static final String HELP_SET = "\tset <config key> <value>\n\n"
            + "The 'set' command sets configuration values that allows you to"
            + " change the behaviour of TASMA. The <config key> is the configuration"
            + " that you want to change and <value> is the new value.\n\n"
            + "\tstorage:\tThe path to the folder where the tasks.json storage file will be stored.\n"
            + "\tshowhint:\tWhether you want to get hints for commands (yes/no).\n"
            + "\thotkey:\tSet the hotkey to use for activating TASMA.";

    public static final String HELP_HELP = "\thelp [command]\n\n"
            + "The 'help' command provides you information on how to use the various"
            + " commands in TASMA. The [command] is the command to show help for"
            + " and can be any of the following:\n\n"
            + "\tadd\t\tedit\t\tdelete\n"
            + "\tlist\t\tsearch\tmark\n"
            + "\tunmark\tset\t\talias\n"
            + "\thelp\t\ttutorial\texit";

    public static final String HELP_ALIAS = "\talias <new alias> <built in command>\n\n"
            + "The 'alias' command allows you to set new commands that function"
            + " the same as other built in commands. The <new alias> can be the"
            + " new custom alias that you want to add and the <built in command>"
            + " will be the existing command to that the new alias will function"
            + " as.\n\nIf you enter in the format of 'alias remove <new alias>',"
            + " it will remove the custom shortcut.";

    public static final String HELP_TUTORIAL = "\ttutorial\n\n"
            + "The 'tutorial' command will launch the welcome tutorial that was"
            + " shown when you first start TASMA.";

    public static final String HELP_EXIT = "\texit\n\n"
            + "The 'exit' command will make TASMA quit its job and move to"
            + " another city.";
    
    public static final String HINT_ADD = "add <task details>\n<task details> the"
            + " details of your task to be added";
    public static final String HINT_SEARCH = "search <query>\n<query> the keywords"
            + " to match your tasks";
    public static final String HINT_LIST= "list [filters]\n[filters] an optional"
            + " keyword to shorten the list of tasks for your convenience";
    public static final String HINT_MARK = "mark <task number>\n<task number> the"
            + " number shown next to the task in the list";
    public static final String HINT_UNMARK = "unmark <task number>\n<task number>"
            + " the number shown next to the task in the list";
    public static final String HINT_DELETE = "delete <task number>\n<task number>"
            + " the number shown next to the task in the list";
    public static final String HINT_EDIT = "edit <task number> [task details]\n<"
            + "task number> the number shown next to the task in the list\n"
            + "[task details] the new details of the task";
    public static final String HINT_SET = "set <config key> <value>\n<config key>"
            + " the configuration key to set new value to\n<value> the new value to set";
    public static final String HINT_ALIAS = "alias <new alias> <built in command>\n"
            + "<new alias> the new shortcut to add in\n<built in command> the existing command to use";
    public static final String HINT_HELP = "help [command]\n[command] the command"
            + " to get help for";
    public static final String HINT_TUTORIAL = "tutorial\nYou can start a new "
            + "tutorial again";
    public static final String HINT_EXIT = "exit\nPress enter and we say goodbye";
    public static final String HINT_UNDO = "undo\nUndo the previous change made";
    public static final String HINT_REDO = "redo\nRedo the previous undo call";
    
}
