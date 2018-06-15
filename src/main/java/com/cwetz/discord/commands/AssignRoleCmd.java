package com.cwetz.discord.commands;

import com.cwetz.discord.util.Logger;

public class AssignRoleCmd extends Command {
    /*
    `/role new-peep
    `/ is bot caller; role is the command; new-peep is an argument for role
    - Need to find bot caller
    - Check which command is being called and call it
    - Pass any arguments to the command
     */

    public AssignRoleCmd() {
        Logger.getInstance().logSuccess("AssignRoleCmd added successfully");
    }
}
