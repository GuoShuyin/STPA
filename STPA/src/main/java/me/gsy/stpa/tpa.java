package me.gsy.stpa;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class tpa implements CommandExecutor, TabCompleter {
    Player player1,player2,PlayerTemp;
    Boolean tpState=false;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        PlayerTemp = (Player) commandSender;
        //判断命令是否合法
        if (strings.length == 1) {
            //判断是否palyer1执行过命令
            if(tpState){
                if(PlayerTemp==player2){
                    if (strings[0].equals("yes")){
                        player1.teleport(player2.getLocation().clone()) ;
                    }
                    else{
                        tpState=false;
                        return false;
                    }

            }else{
                    player1.sendMessage(ChatColor.RED+"你不能自行同意传送");
                }
                tpState=false;
            }
            else{
                player1=(Player) commandSender;
            //    try{
                    player2=player1.getServer().getPlayer(strings[0]);
            //    }
            //    catch (Exception e){
             //       syntaxCheck.sytax((Player) commandSender);

              //  }
                player1.sendMessage(ChatColor.GREEN+"已经发送请求");
                player2.sendMessage(ChatColor.AQUA+player1.getName()+ChatColor.YELLOW+"想要传送到你的位置");
                player2.sendMessage(ChatColor.DARK_GREEN+"输入命令/tpa yes 或 /tpa no");
                tpState=true;
            }
        } else {
            syntaxCheck.sytax((Player) commandSender);
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        if(strings.length==1&&tpState==true){
            List<String> list = new ArrayList<>();
            list.add("yes");
            list.add("no");
            return list;
        }



        return null;
    }

    //  public void sytax() {
    //     Player tempplayer = (Player) commandSender;
    // }
}



