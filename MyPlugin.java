/*     This plugin builds subways across your world.  It's really easy to use.  In the chat window, type:
 *     
 *         /SUBWAY X=n Y=n Z=n D=N|S|E|W L=n   
 *         
 *     You could also spell things out if that's what warps your starship:
 *     
 *         /SUBWAY X=n Y=n Z=n DIRECTION=NORTH|SOUTH|EAST|WEST LENGTH=n
 *     
 *     n is any number.  The plugin will give you an error message if n is out of range for the parameter.
 * 
 *     If all the parameters are valid, the plugin will build a subway starting at X,Y,Z coords in the
 * specified direction for a length of n blocks.  It will build the subway in the dimension you are
 * currently in, be it the World, the Nether, the End, or a custom world.
 * 
 *     The plugin slices time to build the subway, so you can continue playing while the subway is being
 * built without freezing up the server.  You will notice there's a split second pause as it builds each
 * slice of subway tunnel.  It may take a long time to build a long rail line.
 * 
 *     If you specify, for example, X=* Y=* or Z=*, the plugin will use your current location for these
 * values.  If you specify DIRECTION=*, the plugin will build in the direction you are facing, as long
 * as you are facing directly North, South, East or West.  
 * 
 *     If your subway is above ground level, support pillars will be placed every 6 blocks under the
 * tracks to create an E.L.  They will extend downward until they touch solid ground.  
 * If the tracks are over water or lava, the support pillars will extend down into the water or lava 
 * until they reach solid ground.  But if there is no solid ground, such as in The End, there will 
 * be no support pillar.
 * 
 *     If your subway passes through a mountain, tunnel walls will be built around it.  
 * 
 *     WARNING!  The plugin doesn't detect houses, villages, temples, fortresses, strongholds, portals,  
 * sunken ships, mansions, or other players' bases, etc.  It will build the subway through anything in 
 * the way.  Survey your route by eye in Spectator mode before you build!
 * 
 *    You can issue /SUBWAY HALT to halt construction.
 *    
 *    You can issue /SUBWAY RESUME to resume construction that has been halted.
 *
 *    PROPERTIES FILE
 *
 *     This plugin creates a subway.properties file the first time it runs.  The properties file contains
 * several default settings for region and tunnel styles.     
 *
 *     If the properties file specifies REGION=USA or REGION=CANADA, the detectors will be placed ahead 
 * of the powered rails on the right hand side, so that minecarts will accelerate on the right side and 
 * be stopped on the left.  If you specify REGION=UK or REGION=JAPAN, the reverse will be true.
 * 
 *     If the properties file specifies ALIGNMENT=, subway lines will be snap to the nearest parallel
 * multiple of that value.  The default is 6.  For example, if you specify X=13 and Z=8, the plugin 
 * will assume you mean X=12 and Z=6.  This is so that when subways cross, they will intersect without 
 * oddly placed lamp posts and support pillars.
 *    
 *     If the properties file specifies TUNNEL=, this tells the plugin what style you want for your 
 * tunnels. The options are CONCRETE or IRON or STONE or WOOD.
 *
 *     If the properties file specifies BRIDGE=, this tells the plugin what style you want for your 
 * bridges and elevated lines. The options are CONCRETE or IRON or STONE or WOOD.
 * 
 *     If the properties file specifies BOOK=, this tells the plugin the name of the transit guide 
 * book that it gives to a player whenever he passes through a turnstile, or requests a copy of the
 * book.  The default value is SUBWAY.  See TRANSIT GUIDE below.  
 *
 *     If the properties file specifies MESSAGE=, this tells the plugin to send a message to the player
 * whenever he is given a SUBWAY book.  The default message is, "Thank you for riding Fred A. Rapid
 * Transit!"  You may want to change this.
 * 
 *     If the properties file specifies FAST=TRUE, this tells the plugin to place command blocks
 * under the tracks every so often to accelerate the minecarts beyond their normal game speed.  This
 * may be useful if you have a ginormous world with far-flung stations.   If you wish, you may change
 * the commands in the command blocks to teleport the minecarts directly to the next station without
 * breaking the plugin.  You may also want to issue the command: /gamerule commandBlockOutput false 
 * or you'll be nagged constantly whenever someone uses the subway.
 *
 *     Lastly, if you keep the plugin loaded on your server after you build all your subways, it 
 * will protect the subway tracks from griefing and hostile mobs.  The extent of this protection
 * depends on the PROTECT= value.  If you set PROTECT=OFF, there will be no protection, which is
 * best if you are running a private server that only trusted friends will play on or you are 
 * building a world that is not yet open to the public.  If you set PROTECT=MIN, there will be
 * minimal protection protecting the subway from griefing,  If you set PROTECT=MAX, the subway will
 * be protected from griefing, and hostile mobs will not be able to harm players riding on the subway.
 * This last option will stress the server if you have a large an complex subway system.    
 * 
 *     STATIONS 
 * 
 *     What about stations, you ask?  There are so many opinions regarding stations that I'll
 * never please everyone with a one-size-fits-all station.  Some people want an automated station
 * that destroys and stores arriving minecarts and dispenses new ones.  Other people want a simple
 * "train station platform" that the carts move past slowly.  Yet other people want a programmable
 * system where the player dials their destination and the station dispenses a minecart for them.
 * I can't please everyone, so I won't even try.  You have to build your own stations.
 *
 *     TRANSIT GUIDE
 *     
 *     This plugin will give the player a transit guide book when he passes through a turnstile.
 * This feature requires that you also have my BOOK plugin installed.  The book must be in your
 * main server directory and be named "BOOK(SUBWAY).TXT".  Instructions are in my BOOK plugin
 * describing how to format the file to be turned into a Minecraft written book by the plugin.  
 *  
 *     Because turnstiles can come in many shapes and features, I have settled on one particular
 * design that I use on my server.  My turnstiles are two iron blocks resting on the floor with a 
 * glass block on top of each of the iron blocks and a gold or iron pressure plate on the floor 
 * between these objects.  The plugin will detect whenever a player steps on a gold or iron pressure 
 * plate and then check for the iron blocks and glass blocks adjacent to the pressure plate.  If it 
 * detects a turnstile when the player steps on the pressure plate, it will give the player a 
 * transit guide book if he doesn't already have one.  A turnstile can be oriented east/west or 
 * north/south.  Here's a diagram from the view entering the turnstile:
 * 
 *     +-----+     +-----+     
 *     |glass|     |glass|
 *     |block|     |block|  
 *     +-----+     +-----+
 *     |iron |     |iron |
 *     |block| === |block|   That === is a pressure plate on the floor.
 *  ---+-----+-----+-----+---   
 *            floor
 *
 *     KNOWN BUGS
 *     
 *     If one subway line crosses another, the plugin doesn't know what you intend to happen and it
 * gets confused, especially if the two lines aren't at the same Y height.  You'll have to clean 
 * things up and connect the track the way you want.      
 * 
 *    It also gets confused when building a tunnel through a cave where the ground is below the
 * track level.  Do I build a tunnel here, or a bridge?  ¯\_(ツ)_/¯
 * 
 *     Trees are a problem!  The plugin will try to prune trees in a sensible manner along the 
 * tracks so that you don't see trees simply sliced in half or mangled along the way, or leaves 
 * floating in mid-air, but it isn't perfect, such as when the tree-itself isn't in the way but
 * the leaves hang over the right-of-way, or visa-versa.  The Minecraft game engine usually notices
 * clumps of leaves floating in mid-air and lets them despawn naturally, but not always.  So you 
 * will have to do some manual editing along the way.  Sorry...
 * 
 *     Water is also a problem.  Sometimes a subway will intersect some water and the water will start 
 * flowing after the plugin removed the existing block but before it placed the tracks.  That may 
 * result in some water flowing onto the tracks. 
 * 
 *     Sometimes, the subway will disturb loose sand above.  Since sand falls in slow motion relative
 * to game ticks, it will land on the subway after that slice has been built and the plugin has moved
 * on, and so the plugin won't detect it.  So some clean-up may be necessary.  This usually occurs at 
 * tunnel entrances in deserts or if the subway passes through a cave or canyon.
 * 
 *     Also, while this may be obvious, building a subway on a busy server may cause your players
 * to complain about "lag."  Best to build your subways late at night when nobody is playing.
 * 
 *     GO AHEAD AND TRY IT!
 * 
 *     I recommend you play around with this plugin on a test server before building subways
 * on your live server.  Try building elevated lines, underground tunnels, underwater tunnels, 
 * and surface lines, all with each of the different styles.  Also mix and match different
 * styles, for example, iron bridges with concrete tunnels for a New York City look, or concrete 
 * bridges with stone tunnels for a European look.  
 * 
 */
package FredashaySpigotSubway;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CommandBlock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockSpreadEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
	
@SuppressWarnings("unused")
public class MyPlugin extends JavaPlugin implements Listener, CommandExecutor {	
	
	final static char USA = 'A';
	final static char CANADA = 'C';
	final static char UK = 'U';
	final static char JAPAN = 'J';
	final static char NONE = 'N';
	final static char ALL = 'A';
	final static char STONE = 'S';
	final static char CONCRETE = 'C';
	final static char IRON = 'I';
	final static char WOOD = 'W';
	final static char NORTH = 'N';
	final static char EAST = 'E';
	final static char WEST = 'W';
	final static char SOUTH = 'S';
	final static char CRLF = (char) 0x0a;  
	final static int pagecenter = 114;
	final static int PageLines = 13;
	final static int pageChars = 240;	
	final static String dbName = "Fredashay.db";	

	private static Player buildPlayer = null;
	private static boolean building = false; 
	private static int subwayAlignment = 6;
	private static int subwayX = 0;
	private static int subwayY = 0;
	private static int subwayZ = 0;
	private static int distanceStart = 0;
	private static int centerStart = 0;
	private static char subwayDirection = ' ';
	private static int subwayLength = 0;
	private static int subwayDistance = 0;
	private static int subwayComplete = 0;
	private static char subwayRegion = USA;
	private static char tunnelStyle = STONE;
	private static char bridgeStyle = STONE;
	private static byte protection = 1;
	private static boolean semaphore = false;
	private static boolean fast = false;	 	
	private static Logger logger = null;
	private static Properties props = new Properties();
	private static PluginDescriptionFile pdfFile = null;    
	private static int clockDelay = 1;
	private static Random random = new Random();
	private static String bookTitle = "SUBWAY";
	private static String bookFileName = null; 
	private static String bookMessage = "Thank you for riding Fred A. Rapid Transit! ";
	
	@Override
    public void onEnable() {		
		pdfFile = getDescription();
    	getServer().getPluginManager().registerEvents(this,this);  
    	logger = Logger.getLogger("Minecraft");
    	String fileName = pdfFile.getName() + ".properties";  
    	subwayLength = 0;
      	getProperties(fileName);
      	if (subwayRegion == USA) {
      	    logger.info("[" + pdfFile.getName() + "] Region is USA.  Minecarts drive on the right.  ");
      	    }
      	else if (subwayRegion == CANADA) {
      	    logger.info("[" + pdfFile.getName() + "] Region is CANADA.  Minecarts drive on the right.  ");
      	    }
      	else if (subwayRegion == UK) {
      	    logger.info("[" + pdfFile.getName() + "] Region is UK.  Minecarts drive on the left.  ");
      	    }
      	else if (subwayRegion == JAPAN) {
      	    logger.info("[" + pdfFile.getName() + "] Region is JAPAN.  Minecarts drive on the left.  ");
      	    }
      	else {
      		subwayRegion = USA;
      	    logger.info("[" + pdfFile.getName() + "] Region is not in properties.  Defaulting to USA.  Minecarts drive on the right.  ");
      	    }
      	if ((subwayAlignment < 4) || (subwayAlignment > 120)) {
      		subwayAlignment = 6;
      		logger.info("[" + pdfFile.getName() + "] Alignment is not in properties or is not a valid value.  Defaulting to 6.  Parallel tunnels will snap to multiples of 6 blocks between centerlines. ");
      	    }
      	else {
      		logger.info("[" + pdfFile.getName() + "] Alignment is " + subwayAlignment + ".  Parallel tunnels will snap to multiples of 6 blocks between centerlines. ");
      	    }
      	if (tunnelStyle == STONE) {
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is STONE.  Tunnels will be built with stone blocks, giving them a pre-industrial or medieval look.  ");
      	    }
      	else if (tunnelStyle == CONCRETE) {
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is CONCRETE.  Tunnels will be built with concrete, giving them a modern gritty look.  ");
      	    }
    	else if (tunnelStyle == IRON) {
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is IRON.  Tunnels will be built with iron, giving them an industrial steelwork look.  ");
      	    }
    	else if (tunnelStyle == WOOD) {
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is WOOD.  Tunnels will be built with wood, giving them a colonial or mineshaft look.  ");
      	    }
      	else {
      		tunnelStyle = STONE;
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is not in properties.  Defaulting to STONE.  Tunnels will be built with stone blocks, giving them a pre-industrial or medieval look.  ");
      	    }
      	if (bridgeStyle == STONE) {
      	    logger.info("[" + pdfFile.getName() + "] Bridge Style is STONE.  Bridges will be built with stone blocks, like Roman viaducts, giving them a pre-industrial or medieval look.  ");
      	    }
      	else if (bridgeStyle == CONCRETE) {
      	    logger.info("[" + pdfFile.getName() + "] Bridge Style is CONCRETE.  Bridges will be built with concrete, giving them a modern viaduct look.  ");
      	    }
      	else if (bridgeStyle == IRON) {
      	    logger.info("[" + pdfFile.getName() + "] Bridge Style is IRON.  Bridges will be built with iron, giving them an industrial steelwork look.  ");
      	    }
      	else if (bridgeStyle == WOOD) {
      	    logger.info("[" + pdfFile.getName() + "] Bridge Style is WOOD.  Bridges will be built with wood, giving them a colonial look.  ");
      	    }
      	else {
      		bridgeStyle = IRON;
      	    logger.info("[" + pdfFile.getName() + "] Tunnel Style is not in properties.  Defaulting to IRON.  Bridges will be built with iron, giving them an industrial steelwork look.  ");
      	    }
      	if (fast) {
      	    logger.info("[" + pdfFile.getName() + "] Fast travel is on.  Subways will be constructed with command blocks under the tracks to accelerate minecarts through the tunnels at high speed.  ");
      	    }
      	else {
      	    logger.info("[" + pdfFile.getName() + "] Fast travel is off.  Minecarts will travel along the rails at normal game speed.  ");
      	    }
      	if (protection == 0) {
      		logger.info("[" + pdfFile.getName() + "] Protection is OFF.  Subway tunnels aren't protected from mobs or griefing.  This option is best used while building your world before opening it to the public, or if only a few trusted friends will play. ");
      	    }
      	else if (protection == 1) {
      		logger.info("[" + pdfFile.getName() + "] Protection is MINimum.  Subway tunnels are protected from griefing, but not not from mobs.  This option is best used if you have a large and complex subway system and MAXimum protection causes excessive lag. ");
      	    }
      	else if (protection == 2) {
      		logger.info("[" + pdfFile.getName() + "] Protection is MAXimum.  Subway tunnels are protected from griefing and mobs.  This option is best if you have a powerful server, because MAXimum protection puts a heavy load on the CPU, especially if you have a large and complex subway system. ");
      	    }      	
        logger.info("[" + pdfFile.getName() + "] The title of the book in the game is '" + bookTitle + "'.  A player will be given a copy of this book whenever he passes through a turnstile, or may request it with the BOOK command (if you have my BOOK plugin installed). The plugin will look for a file on the server named 'BOOK(" + bookTitle.toUpperCase() + ").TXT'.  ");
        logger.info("[" + pdfFile.getName() + "] The message the player is displayed in chat when he is given a copy of the transit guide book is, '" + bookMessage + "'.  ");
      	logger.info("[" + pdfFile.getName() + "] You can change these by editing FredashaySpigotSubway.properties. ");
    	sqlInit(dbName);
    	bookFileName = getFileName(bookTitle);
	    if (bookFileName == null) {
	    	logger.severe("[" + pdfFile.getName() + "] File \"book(" + bookTitle + ").txt\" is missing. ");
	        }
        }
	
    @Override
    public void onDisable() {
   	    if (building) {
		    building = false;
		    subwayLength = 0;
    	    }
        }
		
	private void getProperties(String fileName) {
		InputStream input = null;
		try {
			input = new FileInputStream(fileName);
			props.load(input);
		    } 
		catch (FileNotFoundException ok) {
 	    	saveProperties(fileName);
 		    }
		catch (IOException oops) {
			logger.severe("[" + pdfFile.getName() + "] Error reading properties file '" + fileName + "'. ");		    
			oops.printStackTrace(System.err);
		    } 
		finally {
			if (input != null) {
			    try {
			        input.close();
			        } 
			    catch (IOException oops) {
				    oops.printStackTrace(System.err);
			        }
				}
			}
		if (props.getProperty("ALIGNMENT") != null) {
          	if (isNumeric(props.getProperty("ALIGNMENT"))) {
          		subwayAlignment = toInteger(props.getProperty("ALIGNMENT"));
              	if ((subwayAlignment < 4) || (subwayAlignment > 120)) {
              		logger.warning("[" + pdfFile.getName() + "] Invalid ALIGNMENT value '" + props.getProperty("ALIGNMENT") + "'.  Must be an integer from 4 to 120.  Using default 6. ");
              		subwayAlignment = 6;
              	    }
      	        }
      	    }
		if (props.getProperty("REGION") != null) {
    		if (props.getProperty("REGION").equalsIgnoreCase("CANADA")) {
    		    subwayRegion = CANADA;
    		    }
    		else if (props.getProperty("REGION").equalsIgnoreCase("JAPAN")) {
    		    subwayRegion = JAPAN;
    		    }
    		else if (props.getProperty("REGION").equalsIgnoreCase("UK")) {
    		    subwayRegion = UK;
    		    }
    		else if (props.getProperty("REGION").equalsIgnoreCase("USA")) {
    		    subwayRegion = USA;
    		    }
    		else {
    			logger.warning("[" + pdfFile.getName() + "] Invalid REGION value '" + props.getProperty("REGION") + "'.  Must be CANADA or JAPAN or UK or USA.  Using default USA. ");
    			subwayRegion = USA;
    		    }
    	    }
		if (props.getProperty("TUNNEL") != null) {
    		if (props.getProperty("TUNNEL").equalsIgnoreCase("CONCRETE")) {
    		    tunnelStyle = CONCRETE;
    		    }
    		else if (props.getProperty("TUNNEL").equalsIgnoreCase("STONE")) {
    		    tunnelStyle = STONE;
    		    }
    		else if (props.getProperty("TUNNEL").equalsIgnoreCase("IRON")) {
    		    tunnelStyle = IRON;
    		    }
    		else if (props.getProperty("TUNNEL").equalsIgnoreCase("WOOD")) {
    		    tunnelStyle = WOOD;
    		    }
    		else {
    			logger.warning("[" + pdfFile.getName() + "] Invalid TUNNEL value '" + props.getProperty("TUNNEL") + "'.  Must be CONCRETE or STONE or IRON or WOOD.  Using default STONE. ");
    			tunnelStyle = STONE;
    		    }    		
    	    }
		if (props.getProperty("BRIDGE") != null) {
    		if (props.getProperty("BRIDGE").equalsIgnoreCase("CONCRETE")) {
    			bridgeStyle = CONCRETE;
    		    }
    		else if (props.getProperty("BRIDGE").equalsIgnoreCase("IRON")) {
    		    bridgeStyle = IRON;
    		    }
    		else if (props.getProperty("BRIDGE").equalsIgnoreCase("STONE")) {
    		    bridgeStyle = STONE;
    		    }
    		else if (props.getProperty("BRIDGE").equalsIgnoreCase("WOOD")) {
    		    bridgeStyle = WOOD;
    		    }
    		else {
    			logger.warning("[" + pdfFile.getName() + "] Invalid BRIDGE value '" + props.getProperty("BRIDGE") + "'.  Must be CONCRETE or STONE or IRON or WOOD.  Using default IRON. ");
    			bridgeStyle = IRON;
    		    }
		    }
		if (props.getProperty("FAST") != null) {
    		if (props.getProperty("FAST").equalsIgnoreCase("TRUE")) {
    			fast = true;
    		    }
    		else if (props.getProperty("FAST").equalsIgnoreCase("FALSE")) {
    			fast = false;
    		    }
    		else {
    			logger.warning("[" + pdfFile.getName() + "] Invalid FAST value '" + props.getProperty("FAST") + "'.  Must be TRUE or FALSE.  Using default FALSE. ");
    			fast = false;
    		    }
		    }
		if (props.getProperty("TITLE") != null) {
			bookTitle = props.getProperty("TITLE");
		    }
		if (props.getProperty("MESSAGE") != null) {
			bookMessage = props.getProperty("MESSAGE");
		    }
		if (props.getProperty("PROTECT") != null) {
    		if (props.getProperty("PROTECT").equalsIgnoreCase("OFF")) {
    			protection = 0;
    		    }
    		else if (props.getProperty("PROTECT").equalsIgnoreCase("FALSE")) {
    			protection = 0;
    		    }
    		else if (props.getProperty("PROTECT").equalsIgnoreCase("MIN")) {
    			protection = 1;
    		    }
    		else if (props.getProperty("PROTECT").equalsIgnoreCase("MAX")) {
    			protection = 2;
    		    }
    		else if (props.getProperty("PROTECT").equalsIgnoreCase("TRUE")) {
    			protection = 2;
    		    }
    		else {
    			logger.warning("[" + pdfFile.getName() + "] Invalid PROTECT value '" + props.getProperty("PROTECT") + "'.  Must be OFF or MIN or MAX.  Using default MIN. ");
    			protection = 1;
		        }
		    }
	    }
	
	private void saveProperties(String fileName) {
		OutputStream output = null;
		try {
			output = new FileOutputStream(fileName);
			props.setProperty("ALIGNMENT", Long.toString(subwayAlignment));
			if (subwayRegion == CANADA) {
			    props.setProperty("REGION", "CANADA");
			    }
			else if (subwayRegion == JAPAN) {
			    props.setProperty("REGION", "JAPAN");
			    }
			else if (subwayRegion == UK) {
			    props.setProperty("REGION", "UK");
			    }
			else if (subwayRegion == USA) {
			    props.setProperty("REGION", "USA");
			    }
			else {
				props.setProperty("REGION", "USA");
			    }
			if (tunnelStyle == CONCRETE) {
			    props.setProperty("TUNNEL", "CONCRETE");
			    }
			else if (tunnelStyle == STONE) {
			    props.setProperty("TUNNEL", "STONE");
			    }
			else if (tunnelStyle == IRON) {
			    props.setProperty("TUNNEL", "IRON");
			    }
			else if (tunnelStyle == WOOD) {
			    props.setProperty("TUNNEL", "WOOD");
			    }
			else {
				props.setProperty("TUNNEL", "STONE");
			    }
			if (bridgeStyle == CONCRETE) {
			    props.setProperty("BRIDGE", "CONCRETE");
			    }
			else if (bridgeStyle == IRON) {
			    props.setProperty("BRIDGE", "IRON");
			    }
			else if (bridgeStyle == STONE) {
			    props.setProperty("BRIDGE", "STONE");
			    }
			else if (bridgeStyle == WOOD) {
			    props.setProperty("BRIDGE", "WOOD");
			    }
			else {
				props.setProperty("BRIDGE", "STONE");
			    }
			if (fast = true) {
			    props.setProperty("FAST", "TRUE");
			    }
			else {
			    props.setProperty("FAST", "FALSE");
			    }
		    props.setProperty("TITLE", bookTitle + " ");
		    props.setProperty("MESSAGE", bookMessage + " ");
		    if (protection <= 0) {
		    	props.setProperty("PROTECT", "OFF ");
		        }
		    else if (protection == 1) {
		    	props.setProperty("PROTECT", "MIN ");
		        }
		    else if (protection >= 2) {
		    	props.setProperty("PROTECT", "MAX ");
		        }
			props.store(output, null);
		    } 
		catch (IOException oops) {
			logger.severe("[" + pdfFile.getName() + "] Error writing properties file '" + fileName + "'. ");
			oops.printStackTrace(System.err);
		    } 
		finally {
			try {
				output.close();
			    } 
			catch (IOException oops) {
				oops.printStackTrace(System.err);
				}
			}
	    }
    		    		
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("SUBWAY")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if ((args.length == 1) && (args[0].toLowerCase().equalsIgnoreCase("halt"))) {
					if (building) {
						building = false;
		            	player.sendMessage("<SUBWAY> Subway construction is halted at " + subwayComplete + "%. "); 					    
		            	}
					else {
						player.sendMessage("<SUBWAY> There is no subway construction at the moment to halt. ");
					    }
				    }
				else if ((args.length == 1) && (args[0].toLowerCase().equalsIgnoreCase("resume"))) {
					if (building) {
						player.sendMessage("<SUBWAY> There is currently a subway under construction. ");
					    }
					else if (subwayLength == 0) {
						player.sendMessage("<SUBWAY> There is no subway construction that has been halted. ");
					    }
					else {
						building = true;
		            	buildPlayer = player;
						player.sendMessage("<SUBWAY> Subway construction is resumed from " + subwayComplete + "%. ");
		            	clock();
					    }
				    }
				else if (building) {
	            	player.sendMessage("<SUBWAY> There is currently a subway under construction.  Please wait before you build another. ");
	                }
	            else {
	            	int argIx = 0;
	            	String arg = null;
	            	String argTag = null;
	            	String argValue = null;
	            	int equal = 0;
	            	boolean error = false;
	            	boolean validX = false;
	            	boolean validY = false;
	            	boolean validZ = false;
	            	boolean validDirection = false;
	            	boolean validLength = false;
	            	int countX = 0;
	            	int countY = 0;
	            	int countZ = 0;
	            	int countD = 0;
	            	int countL = 0;	            			
	            	while ((argIx < args.length) && (error == false)) {
	            		arg = args[argIx].toLowerCase();
	            		equal = arg.indexOf('=');
	            		if (equal < 0) {
	            			player.sendMessage("<SUBWAY> I do not understand '" + arg + "'.  The correct syntax is /SUBWAY KEYWORD=value [KEYWORD=value]... ");
	            			error = true;
	            		    }
	            		else {
	            		    argTag = arg.substring(0,equal);
	            		    argValue = arg.substring(equal + 1,arg.length());
	            		    if (argTag.length() == 0) {
		            			player.sendMessage("<SUBWAY> I do not understand '" + arg + "'.  The correct syntax is /SUBWAY KEYWORD=value [KEYWORD=value]... ");
		            			error = true;
	            		        }
	            		    else if (argValue.length() == 0) {
		            			player.sendMessage("<SUBWAY> I do not understand '" + arg + "'.  The correct syntax is /SUBWAY KEYWORD=value [KEYWORD=value]... ");
		            			error = true;
	            		        }
	            		    else if (argTag.equalsIgnoreCase("X")) {
	            		    	countX = countX + 1;
	            		    	if ((argValue.equals("~") || (argValue.equals("*")))) {
	            		    		subwayX = player.getLocation().getBlockX();
	            		    		validX = true;
	            		    	    }
	            		    	else if (isNumeric(argValue) == false) {
	            		    		player.sendMessage("<SUBWAY> X must be '~' or a positive integer. ");
	            		    		subwayX = player.getLocation().getBlockX();
	            		    		error = true;
	            		    	    }
	            		    	else {
	            		    		subwayX = toInteger(argValue);
	            		    		if (subwayX < 1) {
	            		    			player.sendMessage("<SUBWAY> X must be '~' or a positive integer. ");
	            		    			subwayX = player.getLocation().getBlockX();
	            		    			error = true;
	            		    		    }
	            		    		else {
	            		    			validX = true;
	            		    		    }
	            		    	    }
	            		        }
	            		    else if (argTag.equalsIgnoreCase("Y")) {
	            		    	countY = countY + 1;
	            		    	if ((argValue.equals("~") || (argValue.equals("*")))) {
	            		    		subwayY = player.getLocation().getBlockY();
	            		    		validY = true;
	            		    	    }
	            		    	else if (isNumeric(argValue) == false) {
	            		    		player.sendMessage("<SUBWAY> Y must be '~' or an integer from 1 to 255. ");
	            		    	    }
	            		    	else {
	            		    		subwayY = toInteger(argValue); 
	            		    		if (subwayY < 1) {
	            		    			player.sendMessage("<SUBWAY> Y must be '~' or an integer from 1 to 255. ");
	            		    			subwayY = player.getLocation().getBlockY();
	            		    			error = true;
	            		    		    }
	            		    		else if (subwayY > 255) {
	            		    			player.sendMessage("<SUBWAY> Y must be '~' or an integer from 1 to 255. ");
	            		    			subwayY = player.getLocation().getBlockY();
	            		    			error = true;
	            		    		    }
	            		    		else {
	            		    			validY = true;
	            		    		    }
	            		    	    }		            		    	
            		            }
	            		    else if (argTag.equalsIgnoreCase("Z")) {
	            		    	countZ = countZ + 1;
	            		    	if ((argValue.equals("~") || (argValue.equals("*")))) {
	            		    		subwayZ = player.getLocation().getBlockZ();
	            		    		validZ = true;
	            		    	    }
	            		    	else if (isNumeric(argValue) == false) {
	            		    		player.sendMessage("<SUBWAY> Z must be '~' or a positive integer. ");
	            		    		subwayZ = player.getLocation().getBlockZ();
	            		    		error = true;
	            		    	    }
	            		    	else {
	            		    		subwayZ = toInteger(argValue);
	            		    		if (subwayZ < 1) {
	            		    			player.sendMessage("<SUBWAY> Z must be '~' or a positive integer. ");
	            		    			subwayZ = player.getLocation().getBlockZ();		            		    			 
	            		    			error = true;
	            		    		    }
	            		    		else {
	            		    			validZ = true;
	            		    		    }
	            		    	    }
	            		        }
	            		    else if ((argTag.equalsIgnoreCase("DIRECTION")) || (argTag.equalsIgnoreCase("D"))) {
	            		    	countD = countD + 1;
	            		    	if ((argValue.equals("~") || (argValue.equals("*")))) {
	            		    		float yaw = player.getLocation().getYaw();
			            			while (yaw < 0) {
			            				yaw = yaw + 360;
			            			    }
			            			while (yaw > 360) {
			            				yaw = yaw - 360;
			            			    }
			            			if ((yaw > 340) && (yaw < 380)) {
			            				subwayDirection = SOUTH;
			            				validDirection = true;
			            			    }
			            			else if ((yaw > -20) && (yaw < 20)) {		            				
			            				subwayDirection = SOUTH;
			            				validDirection = true;
			            			    }
			            			else if ((yaw > 70) && (yaw < 110)) {
			            				subwayDirection = WEST;
			            				validDirection = true;
			            			    }
			            			else if ((yaw > 160) && (yaw < 200)) {
			            				subwayDirection = NORTH;
			            				validDirection = true;
			            			    }
			            			else if ((yaw > 250) && (yaw < 290)) {
			            				subwayDirection = EAST;
			            				validDirection = true;
			            			    }
			            			else {
			            				player.sendMessage("<SUBWAY> You are not looking directly NORTH or SOUTH or EAST or WEST.  Look in the direction you want to build. ");
			            				error = true;
			            			    }
	            		    	    }
	            		    	else if ((argValue.equalsIgnoreCase("N") || (argValue.contentEquals("NORTH")))) {
	            		    		subwayDirection = NORTH;
		            				validDirection = true;
	            		    	    }
	            		    	else if ((argValue.equalsIgnoreCase("E") || (argValue.contentEquals("EAST")))) {
	            		    		subwayDirection = EAST;
		            				validDirection = true;		            		    				
	            		    	    }
	            		    	else if ((argValue.equalsIgnoreCase("W") || (argValue.contentEquals("WEST")))) {
	            		    		subwayDirection = WEST;
		            				validDirection = true;
	            		    	    }
	            		    	else if ((argValue.equalsIgnoreCase("S") || (argValue.contentEquals("SOUTH")))) {
	            		    		subwayDirection = SOUTH;
		            				validDirection = true;
	            		    	    }
	            		    	else {				            		    	
	            		    		player.sendMessage("<SUBWAY> DIRECTION must be '~' or NORTH or EAST or WEST or SOUTH. ");
	            		    		error = true;
	            		    		float yaw = player.getLocation().getYaw();
			            			while (yaw < 0) {
			            				yaw = yaw + 360;
			            			    }
			            			while (yaw > 360) {
			            				yaw = yaw - 360;
			            			    }
			            			if ((yaw > 340) && (yaw < 380)) {
			            				subwayDirection = SOUTH;
			            			    }
			            			else if ((yaw > -20) && (yaw < 20)) {		            				
			            				subwayDirection = SOUTH;
			            			    }
			            			else if ((yaw > 70) && (yaw < 110)) {
			            				subwayDirection = WEST;
			            			    }
			            			else if ((yaw > 160) && (yaw < 200)) {
			            				subwayDirection = NORTH;
			            			    }
			            			else if ((yaw > 250) && (yaw < 290)) {
			            				subwayDirection = EAST;
			            			    }
			            			else subwayDirection = NORTH;
		            		    	}
        		                }
		            		else if ((argTag.equalsIgnoreCase("LENGTH")) || (argTag.equalsIgnoreCase("L"))) {	
		            			countL = countL + 1;
	            		    	if (isNumeric(argValue) == false) {
	            		    		player.sendMessage("<SUBWAY> LENGTH must be an integer from 1 to 1000. ");
	            		    		error = true;
	            		    	    }
	            		    	else {
	            		    		subwayLength = toInteger(argValue);
	            		    		if (subwayLength < 1) {
	            		    			player.sendMessage("<SUBWAY> LENGTH must be an integer from 1 to 10000. ");
	            		    			subwayLength = 1;
	            		    			error = true;
	            		    		    }
	            		    		else if (subwayLength > 10000) {
	            		    			player.sendMessage("<SUBWAY> LENGTH must be an integer from 1 to 10000. ");
	            		    			subwayLength = 10000;
	            		    			error = true;
	            		    		    }
	            		    		else {
	            		    			validLength = true;
	            		    		    }
	            		    	    }
	            		        }
			            	else {
		            			player.sendMessage("<SUBWAY> I do not understand '" + arg + "'.  The correct syntax is /SUBWAY KEYWORD=value [KEYWORD=value]... ");
		            			error = true;
	            		        }
	            		    }
	            		argIx = argIx + 1;
	            	    }
	            	if (error == false) {
	            		if (countX < 1) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting X location of your subway. ");
	            		    }
	            		else if (countY < 1) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting Y location of your subway. ");
	            		    }
	            		else if (countZ < 1) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting Z location of your subway. ");
	            		    }
	            		else if (countD < 1) {
	            			player.sendMessage("<SUBWAY> You did not specify the direction of your subway. ");
	            		    }
	            		else if (countL < 1) {
	            			player.sendMessage("<SUBWAY> You did not specify the length of your subway. ");
	            		    }
	            		else if (countX > 1) {
	            			player.sendMessage("<SUBWAY> You specified the starting X location more than once. ");
	            		    }
	            		else if (countY > 1) {
	            			player.sendMessage("<SUBWAY> You specified the starting Y location more than once. ");
	            		    }
	            		else if (countZ > 1) {
	            			player.sendMessage("<SUBWAY> You specified the starting Z location more than once. ");
	            		    }
	            		else if (countD > 1) {
	            			player.sendMessage("<SUBWAY> You specified the direction of your subway more than once. ");
	            		    }
	            		else if (countL > 1) {
	            			player.sendMessage("<SUBWAY> You specified the length of your subway more than once. ");
	            		    }
	            		else if (validX == false) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting X location of your subway correctly. ");
	            		    }
	            		else if (validY == false) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting Y location of your subway correctly. ");
	            		    }
	            		else if (validZ == false) {
	            			player.sendMessage("<SUBWAY> You did not specify the starting Z location of your subway correctly. ");
	            		    }
	            		else if (validDirection == false) {
	            			player.sendMessage("<SUBWAY> You did not specify the direction of your subway correctly. ");
	            		    }
	            		else if (validLength == false) {
	            			player.sendMessage("<SUBWAY> You did not specify the length of your subway correctly. ");
	            		    }
	            		else {	            		
			            	building = true;
			            	subwayDistance = 0;
			            	subwayComplete = 0;
			            	buildPlayer = player;
			            	String dirMessage = null;
			        		if (subwayDirection == NORTH) {
			        			distanceStart = buildPlayer.getLocation().getBlockZ();				
			        			centerStart = buildPlayer.getLocation().getBlockX();
			        			dirMessage = "north";
			        		    }
			        		else if (subwayDirection == SOUTH) {
			        			distanceStart = buildPlayer.getLocation().getBlockZ();				
			        			centerStart = buildPlayer.getLocation().getBlockX();
			        			dirMessage = "south";
			        		    }
			        		else if (subwayDirection == EAST) {
			        			distanceStart = buildPlayer.getLocation().getBlockX();				
			        			centerStart = buildPlayer.getLocation().getBlockZ();
			        			dirMessage = "east";
			        		    }
			        		else if (subwayDirection == WEST) {
			        			distanceStart = buildPlayer.getLocation().getBlockX();				
			        			centerStart = buildPlayer.getLocation().getBlockZ();
			        			dirMessage = "west";
			        		    }			
			        		if (centerStart > 0) {
			        			centerStart = centerStart + 3;
			        		    }
			        		else if (centerStart < 0) {
			        			centerStart = centerStart - 3;
			        		    }
			        		int blah = Math.round(centerStart / 6);
			        		centerStart = blah * 6;			        		
			    		    buildPlayer.sendMessage("<SUBWAY> Starting subway construction at X=" + subwayX + " Y=" + subwayY + " Z=" + subwayZ + " for " + subwayLength + " meters " + dirMessage + ". ");
			    		    logger.info("[" + pdfFile.getName() + "] Starting subway construction at X=" + subwayX + " Y=" + subwayY + " Z=" + subwayZ + " for " + subwayLength + " meters " + dirMessage + ". ");
			            	clock();
	            		    }
	            	    }
	                }
			    }
			else {
				sender.sendMessage("[" + pdfFile.getName() + "] This command can only be issued by a player in the game.  ");
			    }
			return (true);
		    }
		return (false);
        }	
	
	private void clock() {
		if (building) {					
	        getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
	            public void run() {
	                onTick();	             
	                clock();                    
	                }
	            }, clockDelay);
		    }
        }
		
	private boolean opStick(Player player) {
		boolean stick = false;
		if (player.isOp()) {
		    if (player.getInventory().getItemInMainHand().getType().equals(Material.DEBUG_STICK)) {
   	  	        stick = true; 
   	            }
   	        else if (player.getInventory().getItemInOffHand().getType().equals(Material.DEBUG_STICK)) {
   	            stick = true; 
   	            }		
		    }
		return (stick);
	    }
		
	private boolean isNumeric(String string) { 
		double number = 0;
		if (number == 0) {
	        try {	    	
	            number = Double.parseDouble(string);  	        
	            }  
	        catch(NumberFormatException oops) {  
	            return (false);  
	            }
		    }
	    return (true);  
	    }
	
	private int toInteger(String string) {
		int number = 0;
		try {
	        number = Integer.parseInt(string.trim());
	        }
	    catch (NumberFormatException oops) {
	    	logger.warning("[" + pdfFile.getName() + "] I tried to convert '" + string + "' to a number; it didn't end well.  ");
	    	logger.warning("[" + pdfFile.getName() + "] " + oops.getMessage());
			oops.printStackTrace(System.err);
			number = 0;
	        }
		return (number);		
	    }
	
    private static String hexEncode(String textValue) {
	    char[] chars = textValue.toCharArray();
	    String hex = "#";
	    int ix = 0;
	    while (ix < chars.length) {
	    	try {
	    	    hex = hex + Integer.toHexString((int) chars[ix]);
	    	    }
	    	catch (Exception oops) {
				return ("#00");
			    }
	    	ix = ix + 1;
	        }
	    return (hex);
	    }
	
	private static String hexDecode(String hexValue) {		
		String textValue = "";
		if (hexValue.startsWith("#")) {
			int ix = 1;
			while (ix < hexValue.length()) {
				try {
		            textValue = textValue + (char) Integer.parseInt(hexValue.substring(ix, (ix + 2)), 16);
				    }
				catch (Exception oops) {
					return (" ");
				    }				
		        ix = ix + 2;
		        }			
		    }
	    return (textValue);
	    } 	
	
	private void sqlInit(String dbName) {
	   	Connection connection = sqlOpen(dbName);
	   	PreparedStatement statement = null;
	   	try { 
	   		statement = connection.prepareStatement("create table if not exists subway (world varchar(255), locx long, locy int, locz long);  ");
			sqlUpdate(connection, statement);		
	   	    }	 
		catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);       	
			} 
	   	finally {
	   	    sqlClose(connection);
	   	    }
	    }
	
    private Connection sqlOpen(String dbNname) {
    	Connection connection = null;
    	try { 
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);
    	    }
    	catch (ClassNotFoundException oops) {
        	logger.severe("[" + pdfFile.getName() + "] You need the SQLite JBDC library.  DuckDuckGo it. ");
        	oops.printStackTrace(System.err);
        	}
        catch(SQLException oops) {
       	    logger.severe("[" + pdfFile.getName() + "] SQL Exception: '" + oops.getErrorCode() + "'. ");
            oops.printStackTrace();  
            }
		catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);       	
			} 
    	return (connection);
        }
          
    private ResultSet sqlQuery(Connection connection, PreparedStatement statement) { 
    	ResultSet data = null;
    	try { 
            data = statement.executeQuery();
    	    } 
        catch(SQLException oops) {
       	    logger.severe("[" + pdfFile.getName() + "] SQL Exception: '" + oops.getErrorCode() + "'. ");
            oops.printStackTrace();  
            }
		catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);
		    }   
        return (data);
        }
    
    private void sqlUpdate(Connection connection, PreparedStatement statement) { 
    	try { 
    		statement.executeUpdate();
	        }
        catch(SQLException oops) {
       	    logger.severe("[" + pdfFile.getName() + "] SQL Exception: '" + oops.getErrorCode() + "'. ");
            oops.printStackTrace();  
            }
		catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);
		    }   
        }
        
    private void sqlClose(Connection connection) {
    	if (connection != null) {
			try {
				connection.close();
			    } 
			catch(SQLException oops) {
	       	    logger.severe("[" + pdfFile.getName() + "] SQL Exception: '" + oops.getErrorCode() + "'. ");
	            oops.printStackTrace();  
	            }
			catch (Exception oops) {
	       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
	       	    oops.printStackTrace(System.err);
			    }  
			}
        }
    
    private void insertBlock(Block block) {
    	Connection connection = sqlOpen(dbName);
    	try {   
    		PreparedStatement statement = connection.prepareStatement("insert into subway values(?, ?, ?, ?); ");
    		statement.setString(1, hexEncode(block.getWorld().getUID().toString()));
        	statement.setLong(2, block.getX());
        	statement.setInt(3, block.getY());
        	statement.setLong(4, block.getZ());
        	sqlUpdate(connection, statement);	
    	    }
    	catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);       	
			}
	   	finally {
	   	    sqlClose(connection);
	   	    }
        }
    
    private boolean queryProtectedLocation(Location location) {
        boolean protect = false;
    	Connection connection = sqlOpen(dbName);
    	try {   
        	PreparedStatement statement = connection.prepareStatement("select * from subway where world=? and locx=? and locy=? and locz=?; ");
        	statement.setString(1, hexEncode(location.getWorld().getUID().toString()));
        	statement.setLong(2, location.getBlockX());
        	statement.setInt(3, location.getBlockY());
        	statement.setLong(4, location.getBlockZ());
        	ResultSet data = sqlQuery(connection, statement);
        	if (data != null) {
        		if (data.next()) {
        		    protect = true;
        		    }
        	    }
    	    }
    	catch (Exception oops) {
       	    logger.severe("[" + pdfFile.getName() + "] Exception: '" + oops.getMessage() + "'. ");        
       	    oops.printStackTrace(System.err);       	
    		}
       	finally {
       	    sqlClose(connection);
       	    }
    	return (protect);
        }	
    
	private void onTick() {
		if (building) {
			if (subwayDistance >= subwayLength) {
				building = false;
				subwayLength = 0;
				buildPlayer.getWorld().save();
				logger.info("[" + pdfFile.getName() + "] Subway construction is complete. ");
				buildPlayer.sendMessage("<SUBWAY> Your subway is complete. ");
			    }
			else if (semaphore) {
				logger.info("[" + pdfFile.getName() + "] Server looks like it is struggling.  Subway construction speed reduced. ");
			    clockDelay = clockDelay * 2;
			    while (semaphore) {}
			    }
			else {
			    semaphore = true;
			    buildSubwaySlice();
			    if (subwayDistance == 0) {
					tpPlayer(subwayDistance, 0, 0);
			        }
				subwayDistance = subwayDistance + 1;
				float blah1 = (float) subwayDistance;
				float blah2 = (float) subwayLength;
				float blah3 = blah1 / blah2;
				float blah4 = blah3 * 100;
				int blah5 = (int) Math.floor(blah4);				
				if (blah5 > subwayComplete) {
					buildPlayer.getWorld().save();
					subwayComplete = blah5; 
				    logger.info("[" + pdfFile.getName() + "] Subway is " + subwayComplete + "% complete. ");
				    }
				semaphore = false;
			    }
		    }		
	    }
	
	private void buildSubwaySlice() {
		int actualDistance = absoluteDistance(subwayDistance);
		boolean snapPoint = false;
		boolean snapPoint_1 = false;
		boolean snapPoint_2 = false;
		boolean snapPoint_3 = false;
		boolean snapPoint_4 = false;
		boolean snapPoint_5 = false;
		boolean sinking = false;
		Material thing = null;
		int height = 0;
		int column = 0;
		int randomNumber = 0;		
			
		if ((Math.floor(actualDistance / 12) * 12) == actualDistance) {
			snapPoint = true;
		    }
		else if ((Math.floor((actualDistance - 1) / 12) * 12) == (actualDistance - 1)) {
			snapPoint_1 = true; 
		    }
		else if ((Math.floor((actualDistance + 1) / 12) * 12) == (actualDistance + 1)) {
			snapPoint_1 = true;
		    }
		else if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
			snapPoint_2 = true; 
		    }
		else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
			snapPoint_2 = true;
		    }
		else if ((Math.floor((actualDistance - 3) / 12) * 12) == (actualDistance - 3)) {
			snapPoint_3 = true; 
		    }
		else if ((Math.floor((actualDistance + 3) / 12) * 12) == (actualDistance + 3)) {
			snapPoint_3 = true;
		    }
		else if ((Math.floor((actualDistance - 4) / 12) * 12) == (actualDistance - 4)) {
			snapPoint_4 = true; 
		    }
		else if ((Math.floor((actualDistance + 4) / 12) * 12) == (actualDistance + 4)) {
			snapPoint_4 = true;
		    }
		else if ((Math.floor((actualDistance - 5) / 12) * 12) == (actualDistance - 5)) {
			snapPoint_5 = true; 
		    }
		else if ((Math.floor((actualDistance + 5) / 12) * 12) == (actualDistance + 5)) {
			snapPoint_5 = true;
		    }
				
		/* identify what's in the path of the tunnel before we build it */
		
		// At61 |At62 |At63 |At64 |At65 |At66 |At67
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		// At51 |At52 |At53 |At54 |At55 |At56 |At57
		//      | 2,-2| 2,-1| 2, 0| 2, 1| 2, 2|
		//   ---+-----+-----+-----+-----+-----+---
		// At41 |At42 |       | |       |At46 |At47
		//      | 1,-2|       | |       | 1, 2|
		//   ---+-----+       +-+       +-----+---
		// At31 |AT32 |       | |       |At36 |At37
		//      | 0,-2| ===   | |   === | 0, 2|		
		//   ---+-----+-----+-----+-----+-----+---
		// At21 |At22 |At23 |At24 |At25 |At26 |At27
		//      |-1,-2|-1,-1|-1, 0|-1, 1|-1, 2|
		//   ---+-----+-----+-----+-----+-----+---
		// At11 |At12 |At13 |At14 |At15 |At16 |At17
		//      |     |     |     |     |     |
		
		Material whatsAt11 = getBlockType(subwayDistance,-2,-3);
		Material whatsAt12 = getBlockType(subwayDistance,-2,-2);
		Material whatsAt13 = getBlockType(subwayDistance,-2,-1);
		Material whatsAt14 = getBlockType(subwayDistance,-2, 0);
		Material whatsAt15 = getBlockType(subwayDistance,-2, 1);
		Material whatsAt16 = getBlockType(subwayDistance,-2, 2);
		Material whatsAt17 = getBlockType(subwayDistance,-2, 3);
		
		Material whatsAt21 = getBlockType(subwayDistance,-1,-3);
		Material whatsAt22 = getBlockType(subwayDistance,-1,-2);
		Material whatsAt23 = getBlockType(subwayDistance,-1,-1);
		Material whatsAt24 = getBlockType(subwayDistance,-1, 0);
		Material whatsAt25 = getBlockType(subwayDistance,-1, 1);
		Material whatsAt26 = getBlockType(subwayDistance,-1, 2);
		Material whatsAt27 = getBlockType(subwayDistance,-1, 3);
		
		Material whatsAt31 = getBlockType(subwayDistance, 0,-3);
		//Material whatsAt32 = getBlockType(subwayDistance, 0,-2);
		//Material whatsAt33 = getBlockType(subwayDistance, 0,-1);
		//Material whatsAt34 = getBlockType(subwayDistance, 0, 0);
		//Material whatsAt35 = getBlockType(subwayDistance, 0, 1);
		//Material whatsAt36 = getBlockType(subwayDistance, 0, 2);
		Material whatsAt37 = getBlockType(subwayDistance, 0, 3);

		Material whatsAt41 = getBlockType(subwayDistance, 1,-3);
		Material whatsAt42 = getBlockType(subwayDistance, 1,-2);
		//Material whatsAt43 = getBlockType(subwayDistance, 1,-1);
		//Material whatsAt44 = getBlockType(subwayDistance, 1, 0);
		//Material whatsAt45 = getBlockType(subwayDistance, 1, 1);
		Material whatsAt46 = getBlockType(subwayDistance, 1, 2);
		Material whatsAt47 = getBlockType(subwayDistance, 1, 3);
		
		Material whatsAt51 = getBlockType(subwayDistance, 2,-3);
		Material whatsAt52 = getBlockType(subwayDistance, 2,-2);
		//Material whatsAt53 = getBlockType(subwayDistance, 2,-1);
		//Material whatsAt54 = getBlockType(subwayDistance, 2, 0);
		//Material whatsAt55 = getBlockType(subwayDistance, 2, 1);
		Material whatsAt56 = getBlockType(subwayDistance, 2, 2);
		Material whatsAt57 = getBlockType(subwayDistance, 2, 3);
		
		//Material whatsAt61 = getBlockType(subwayDistance, 3,-3);
		Material whatsAt62 = getBlockType(subwayDistance, 3,-2);
		Material whatsAt63 = getBlockType(subwayDistance, 3,-1);
		Material whatsAt64 = getBlockType(subwayDistance, 3, 0);
		Material whatsAt65 = getBlockType(subwayDistance, 3, 1);
		Material whatsAt66 = getBlockType(subwayDistance, 3, 2);
		//Material whatsAt67 = getBlockType(subwayDistance, 3, 3);	
		
		/* clear center of tunnel */
		changeBlockType(subwayDistance, 1,-1,Material.AIR);
		changeBlockType(subwayDistance, 1, 0,Material.AIR);
		changeBlockType(subwayDistance, 1, 1,Material.AIR);
		changeBlockType(subwayDistance, 0,-1,Material.AIR);
		changeBlockType(subwayDistance, 0, 0,Material.AIR);
		changeBlockType(subwayDistance, 0, 1,Material.AIR);
		
		/* determine whether we are underground, above ground, or under water */

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |At22 |     |     |     |     |
		//      |-1,-2|     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (whatsAt21 == Material.IRON_BLOCK) {
			changeBlockType(subwayDistance,-1,-2,Material.IRON_BLOCK);
		    }   
		else if ((solidBlock(whatsAt12)) || (liquidBlock(whatsAt12)) || (liquidBlock(whatsAt22))) {	
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1,-2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance,-1,-2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) { 
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance,-1,-2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance,-1,-2,Material.COBBLESTONE);
				    }
			    }
			else if (tunnelStyle == WOOD) {
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance,-1,-2,Material.COBBLESTONE);          
			        }
				else {
					if (solidBlock(whatsAt12)) {
				        changeBlockType(subwayDistance,-1,-2,Material.GRAVEL);            
					    }
					else if ((waterBlock(whatsAt12)) || (waterBlock(whatsAt11))) {   
						changeBlockType(subwayDistance,-1,-2,Material.MOSSY_COBBLESTONE);
					    }
					else {
						changeBlockType(subwayDistance,-1,-2,Material.COBBLESTONE);           
					    }
				    }
			    }
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1,-2,Material.WHITE_CONCRETE);
			    }
			else if (bridgeStyle == IRON) {
				changeBlockType(subwayDistance,-1,-2,Material.IRON_BARS);   
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance,-1,-2,Material.STONE_BRICKS);
			    }
		    }

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |At24 |     |     |
		//      |     |     |-1, 0|     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if ((whatsAt21 == Material.IRON_BLOCK) || (whatsAt27 == Material.IRON_BLOCK)) {
			changeBlockType(subwayDistance,-1, 0,Material.IRON_BLOCK);
		    }		
		else if ((solidBlock(whatsAt14)) || (liquidBlock(whatsAt14)) || (liquidBlock(whatsAt24))) {    
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 0,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance,-1, 0,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                  
				changeBlockType(subwayDistance,-1, 0,Material.COBBLESTONE);          
			    }
			else if (tunnelStyle == WOOD) {    
				if (solidBlock(whatsAt14)) {
			        changeBlockType(subwayDistance,-1, 0,Material.GRAVEL);           
				    }
				else {
					changeBlockType(subwayDistance,-1, 0,Material.COBBLESTONE);      
				    }
			    }
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 0,Material.WHITE_CONCRETE);
			    }
			else if (bridgeStyle == IRON) {
				changeBlockType(subwayDistance,-1, 0,Material.IRON_BARS);
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance,-1, 0,Material.STONE_BRICKS);
			    }
			else if (bridgeStyle == WOOD) {
				changeBlockType(subwayDistance,-1, 0,Material.OAK_PLANKS);
			    }
		    }

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |At26 |
		//      |     |     |     |     |-1, 2|
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (whatsAt27 == Material.IRON_BLOCK) {
			changeBlockType(subwayDistance,-1, 2,Material.IRON_BLOCK);
		    }  
		else if ((solidBlock(whatsAt16)) || (liquidBlock(whatsAt16)) || (liquidBlock(whatsAt26))) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance,-1, 2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                  
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance,-1, 2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance,-1, 2,Material.COBBLESTONE);
				    }
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance,-1, 2,Material.COBBLESTONE);      
			        }
				else {
					if (solidBlock(whatsAt16)) {
				        changeBlockType(subwayDistance,-1, 2,Material.GRAVEL);       
					    }
					else if ((waterBlock(whatsAt16)) || (waterBlock(whatsAt17))) {      
						changeBlockType(subwayDistance,-1, 2,Material.MOSSY_COBBLESTONE);
					    }
					else {
						changeBlockType(subwayDistance,-1, 2,Material.COBBLESTONE);           
					    }
				    }
			    }
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 2,Material.WHITE_CONCRETE);
			    }
			else if (bridgeStyle == IRON) {
				changeBlockType(subwayDistance,-1, 2,Material.IRON_BARS);     				
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance,-1, 2,Material.STONE_BRICKS);
			    }
		    }
		
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |At32 |       | |       |     |
		//      | 0,-2| ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (railBlock(whatsAt31)) {
			changeBlockType(subwayDistance, 0,-2,Material.AIR);			
		    }
		else if ((solidBlock(whatsAt31))) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 0,-2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 0,-2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                  
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance, 0,-2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance, 0,-2,Material.IRON_BARS);
				    }
			    }
			else if (tunnelStyle == WOOD) {   
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 0,-2,Material.OAK_PLANKS);    
			        }
				else {
				    changeBlockType(subwayDistance, 0,-2,Material.AIR);      
				    }
			    }
		    }
		else if (liquidBlock(whatsAt31)) {
			changeBlockType(subwayDistance, 0,-2,Material.GLASS);
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance, 0,-2,Material.IRON_BARS);
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance, 0,-2,Material.STONE_BRICK_WALL);
			    }
			else {
				if ((solidBlock(whatsAt11)) || (whatsAt42 == Material.IRON_BARS)) {
					changeBlockType(subwayDistance, 0,-2,Material.IRON_BARS);
				    }
				else if (tunnelStyle == IRON) {                                  
                    if (whatsAt25 == Material.IRON_BLOCK) {				  
						changeBlockType(subwayDistance, 0,-2,Material.IRON_BLOCK);
                        }
                    else {
					    changeBlockType(subwayDistance, 0,-2,Material.AIR);
                        }                    
				    }
				else if (tunnelStyle == WOOD) {                                  
                    if (whatsAt25 == Material.OAK_PLANKS) {				  
						changeBlockType(subwayDistance, 0,-2,Material.OAK_PLANKS);
                        }
                    else {
					    changeBlockType(subwayDistance, 0,-2,Material.AIR);
                        }                    
				    }
                else {
				    changeBlockType(subwayDistance, 0,-2,Material.AIR);
                    }
			    }
			}
		if ((airBlock(getBlockType(subwayDistance, 0,-2))) && (getBlockType(subwayDistance, 1,-2) == Material.IRON_BARS)) {
			changeBlockType(subwayDistance, 0,-2,Material.IRON_BARS);
		    }
		
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |At36 |
		//      |     | ===   | |   === | 0, 2|		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (railBlock(whatsAt37)) {
			changeBlockType(subwayDistance, 0, 2,Material.AIR);
		    }
		else if ((solidBlock(whatsAt37))) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 0, 2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 0, 2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                 
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance, 0, 2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance, 0, 2,Material.IRON_BARS);
				    }
			    }
			else if (tunnelStyle == WOOD) { 
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 0, 2,Material.OAK_PLANKS);    
			        }
				else {
				    changeBlockType(subwayDistance, 0, 2,Material.AIR); 
				    }
			    }
		    }
		else if (liquidBlock(whatsAt37)) {
			changeBlockType(subwayDistance, 0, 2,Material.GLASS);
		    }
		else {			
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance, 0, 2,Material.IRON_BARS);
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance, 0, 2,Material.STONE_BRICK_WALL);
			    }
			else {
				if ((solidBlock(whatsAt17)) || (whatsAt46 == Material.IRON_BARS)) {
					changeBlockType(subwayDistance, 0, 2,Material.IRON_BARS);
				    }
				else if (tunnelStyle == IRON) {                                  
                    if (whatsAt65 == Material.IRON_BLOCK) {				  
						changeBlockType(subwayDistance, 0, 2,Material.IRON_BLOCK);
                        }
                    else {
					    changeBlockType(subwayDistance, 0, 2,Material.AIR);
                        }
				    }
				else if (tunnelStyle == WOOD) {                                  
                    if (whatsAt65 == Material.OAK_PLANKS) {				  
						changeBlockType(subwayDistance, 0, 2,Material.OAK_PLANKS);
                        }
                    else {
					    changeBlockType(subwayDistance, 0, 2,Material.AIR);
                        }                    
				    }
				else {
					changeBlockType(subwayDistance, 0, 2,Material.AIR);
				    }
			    }
			}
		if ((airBlock(getBlockType(subwayDistance, 0, 2))) && (getBlockType(subwayDistance, 1, 2) == Material.IRON_BARS)) {
			changeBlockType(subwayDistance, 0, 2,Material.IRON_BARS);
		    }

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |At42 |       | |       |     |
		//      | 1,-2|       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (solidBlock(whatsAt41)) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 1,-2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 1,-2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                 
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance, 1,-2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance, 1,-2,Material.IRON_BARS);
				    }
			    }
			else if (tunnelStyle == WOOD) {				
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 1,-2,Material.OAK_PLANKS);     
			        }
				else {
				    changeBlockType(subwayDistance, 1,-2,Material.AIR);           
				    }
			    }
		    }
		else if (liquidBlock(whatsAt41)) {
			changeBlockType(subwayDistance, 1,-2,Material.GLASS);
		    }
		else { 
			if (solidBlock(whatsAt11)) {
				changeBlockType(subwayDistance, 1,-2,Material.IRON_BARS);
			    }
			else {
				changeBlockType(subwayDistance, 1,-2,Material.AIR);
			    }
		    }
		
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |At46 |
		//      |     |       | |       | 1, 2|
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (solidBlock(whatsAt47))  {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 1, 2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 1, 2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                 
				if (snapPoint_1 || snapPoint_5) {
					changeBlockType(subwayDistance, 1, 2,Material.IRON_BLOCK);
				    }
				else {
				    changeBlockType(subwayDistance, 1, 2,Material.IRON_BARS);
				    }
			    }
			else if (tunnelStyle == WOOD) {          
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 1, 2,Material.OAK_PLANKS);    
			        }
				else {
				    changeBlockType(subwayDistance, 1, 2,Material.AIR);           
				    }
			    }
		    }
		else if (liquidBlock(whatsAt47)) {
			changeBlockType(subwayDistance, 1, 2,Material.GLASS);
		    }
		else {
			if (solidBlock(whatsAt17)) {
				changeBlockType(subwayDistance, 1, 2,Material.IRON_BARS);
			    }
			else {
				changeBlockType(subwayDistance, 1, 2,Material.AIR);
			    }
		    }
		
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |At52 |     |     |     |     |
		//      | 2,-2|     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (whatsAt52 == Material.GLASS) {
			changeBlockType(subwayDistance, 2,-2,Material.GLASS);
		    }
		else if ((solidBlock(whatsAt62)) || (solidBlock(whatsAt51)))  { 
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 2,-2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 2,-2,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {
			    changeBlockType(subwayDistance, 2,-2,Material.IRON_BLOCK);         
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 2,-2,Material.OAK_PLANKS);     
			        }
				else {
					removeSand(subwayDistance, 2,-2);
					changeBlockType(subwayDistance, 2,-2,Material.AIR);        
				    }
			    }
		    }
		else if ((liquidBlock(whatsAt62)) || (liquidBlock(whatsAt51))) {
			changeBlockType(subwayDistance, 2,-2,Material.GLASS);
		    }
		else {
			removeSand(subwayDistance, 2, -2);
		    changeBlockType(subwayDistance, 2,-2,Material.AIR);
			}

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |At53 |     |     |     |
		//      |     | 2,-1|     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (solidBlock(whatsAt63)) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 2,-1,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 2,-1,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {
				if (snapPoint_1 || snapPoint_5) {
				    changeBlockType(subwayDistance, 2,-1,Material.IRON_BLOCK);    
			        }
				else {
					changeBlockType(subwayDistance, 2,-1,Material.IRON_BARS);     
				    }
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 2,-1,Material.OAK_PLANKS);    
			        }
				else {
					removeSand(subwayDistance, 2,-1);
					changeBlockType(subwayDistance, 2,-1,Material.AIR);           
				    }
			    }
		    }
		else if (liquidBlock(whatsAt63)) {
			changeBlockType(subwayDistance, 2,-1,Material.GLASS);
		    }
		else {
			removeSand(subwayDistance, 2,-1);
			changeBlockType(subwayDistance, 2,-1,Material.AIR);
			}

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |At54 |     |     |
		//      |     |     | 2, 0|     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (solidBlock(whatsAt64)) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 2, 0,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 2, 0,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {
				if (snapPoint_1 || snapPoint_5) {
				    changeBlockType(subwayDistance, 2, 0,Material.IRON_BLOCK);      
			        }
				else {
					changeBlockType(subwayDistance, 2, 0,Material.IRON_BARS);       
				    }
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 2, 0,Material.OAK_PLANKS);      
			        }
				else {
					removeSand(subwayDistance, 2, 0);
					changeBlockType(subwayDistance, 2, 0,Material.AIR);             
				    }
			    }
			if (snapPoint_1) {
				if (whatsAt64 == Material.WATER) {                  
					randomNumber = random.nextInt(4);
					if (randomNumber == 0) {
					    changeBlockType(subwayDistance, 0, 0,Material.MOSSY_STONE_BRICK_WALL);
					    changeBlockType(subwayDistance, 1, 0,Material.MOSSY_STONE_BRICK_WALL);
					    }
					else {
					    changeBlockType(subwayDistance, 0, 0,Material.STONE_BRICK_WALL);
					    changeBlockType(subwayDistance, 1, 0,Material.STONE_BRICK_WALL);
					    }
				    }
				else {
				    changeBlockType(subwayDistance, 0, 0,Material.STONE_BRICK_WALL);
				    changeBlockType(subwayDistance, 1, 0,Material.STONE_BRICK_WALL);
				    }
			    }
			else {
				changeBlockType(subwayDistance, 0, 0,Material.IRON_BARS);
			    }
		    }
		else if (liquidBlock(whatsAt64)) {
			changeBlockType(subwayDistance, 2, 0,Material.GLASS);
			if (snapPoint_1) {
				changeBlockType(subwayDistance, 0, 0,Material.STONE_BRICK_WALL);
				changeBlockType(subwayDistance, 1, 0,Material.STONE_BRICK_WALL);
				if (tunnelStyle == CONCRETE) {
					changeBlockType(subwayDistance, 2, 0,Material.GRAY_CONCRETE);
				    }
				else if (tunnelStyle == STONE) {
					changeBlockType(subwayDistance, 2, 0,Material.STONE_BRICKS);
				    }
			    } 
			else if (snapPoint == false) {
				changeBlockType(subwayDistance, 0, 0,Material.IRON_BARS);    
			    }    
		    }
		else {
			removeSand(subwayDistance, 2, 0);
			changeBlockType(subwayDistance, 2, 0,Material.AIR);
			}

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |At55 |     |
		//      |     |     |     | 2, 1|     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if (solidBlock(whatsAt65)) {
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 2, 1,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 2, 1,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {
				if (snapPoint_1 || snapPoint_5) {
				    changeBlockType(subwayDistance, 2, 1,Material.IRON_BLOCK);           
			        }
				else {
					changeBlockType(subwayDistance, 2, 1,Material.IRON_BARS);            
				    }
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 2, 1,Material.OAK_PLANKS);           
			        }
				else {
					removeSand(subwayDistance, 2, 1);
					changeBlockType(subwayDistance, 2, 1,Material.AIR);            
				    }
			    }
		    }
		else if (liquidBlock(whatsAt65)) {
			changeBlockType(subwayDistance, 2, 1,Material.GLASS);
		    }
		else {
			removeSand(subwayDistance, 2, 1);
			changeBlockType(subwayDistance, 2, 1,Material.AIR);
			}		
		
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |At56 |
		//      |     |     |     |     | 2, 2|
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if  (whatsAt56 == Material.GLASS) {
			changeBlockType(subwayDistance, 2, 2,Material.GLASS);
		    }
		else if ((solidBlock(whatsAt66)) || (solidBlock(whatsAt57))) {	
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance, 2, 2,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance, 2, 2,Material.STONE_BRICKS); 
			    }
			else if (tunnelStyle == IRON) {
			    changeBlockType(subwayDistance, 2, 2,Material.IRON_BLOCK);            
			    }
			else if (tunnelStyle == WOOD) {  
				if (snapPoint || snapPoint_1) {
				    changeBlockType(subwayDistance, 2, 2,Material.OAK_PLANKS);        
			        }
				else {
					removeSand(subwayDistance, 2, 2);
					changeBlockType(subwayDistance, 2, 2,Material.AIR);            
				    }
			    }
		    }
		else if ((liquidBlock(whatsAt66)) || (liquidBlock(whatsAt57))) {
			changeBlockType(subwayDistance, 2, 2,Material.GLASS);
		    }
		else {
			removeSand(subwayDistance, 2, 2);
		    changeBlockType(subwayDistance, 2, 2,Material.AIR);
			}
			
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |At23 |     |     |     |
		//      |     |-1,-1|     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if ((solidBlock(whatsAt13)) || (liquidBlock(whatsAt23))) {        
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1,-1,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance,-1,-1,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                  
				changeBlockType(subwayDistance,-1,-1,Material.COBBLESTONE);         
			    }
			else if (tunnelStyle == WOOD) {                                 
				if (solidBlock(whatsAt13)) {
					changeBlockType(subwayDistance,-1,-1,Material.GRAVEL);      
				    }
				else {
				    changeBlockType(subwayDistance,-1,-1,Material.COBBLESTONE);         				    
				    }            
			    }
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1,-1,Material.WHITE_CONCRETE);
			    }
			else if (bridgeStyle == IRON) {
				changeBlockType(subwayDistance,-1,-1,Material.IRON_BLOCK);
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance,-1,-1,Material.STONE_BRICKS);
			    }
			else if (bridgeStyle == WOOD) {
				changeBlockType(subwayDistance,-1,-1,Material.OAK_PLANKS);
			    }
		    }

		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		//      |     |     |     |     |     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |       | |       |     |
		//      |     |       | |       |     |
		//   ---+-----+       +-+       +-----+---
		//      |     |       | |       |     |
		//      |     | ===   | |   === |     |		
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |At25 |     |
		//      |     |     |     |-1, 1|     |
		//   ---+-----+-----+-----+-----+-----+---
		//      |     |     |     |     |     |
		if ((solidBlock(whatsAt15)) || (liquidBlock(whatsAt25))) {            
			if (tunnelStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 1,Material.GRAY_CONCRETE);
			    }
			else if (tunnelStyle == STONE) {
				changeBlockType(subwayDistance,-1, 1,Material.STONE_BRICKS);
			    }
			else if (tunnelStyle == IRON) {                                  
				changeBlockType(subwayDistance,-1, 1,Material.COBBLESTONE);  
			    }
			else if (tunnelStyle == WOOD) {
				if (solidBlock(whatsAt15)) {
					changeBlockType(subwayDistance,-1, 1,Material.GRAVEL);           
				    }
				else {
				    changeBlockType(subwayDistance,-1, 1,Material.COBBLESTONE);       				    
				    }
			    }
		    }
		else {
			if (bridgeStyle == CONCRETE) {
				changeBlockType(subwayDistance,-1, 1,Material.WHITE_CONCRETE);
			    }
			else if (bridgeStyle == IRON) {
				changeBlockType(subwayDistance,-1, 1,Material.IRON_BLOCK);       
			    }
			else if (bridgeStyle == STONE) {
				changeBlockType(subwayDistance,-1, 1,Material.STONE_BRICKS);
			    }
			else if (bridgeStyle == WOOD) {
				changeBlockType(subwayDistance,-1, 1,Material.OAK_PLANKS);
			    }
		    }
				
		/* place tunnel interior and track */		
		if (snapPoint) {
			changeBlockType(subwayDistance, 0,-1,Material.POWERED_RAIL);
			changeBlockType(subwayDistance, 0, 1,Material.POWERED_RAIL);
			tpPlayer((subwayDistance - 1), 0, 0);
			changeBlockType(subwayDistance, 0, 0,Material.REDSTONE_TORCH);
		    }
		else if ((Math.floor((actualDistance - 1) / 12) * 12) == (actualDistance - 1)) {
			changeBlockType(subwayDistance, 0,-1,Material.RAIL);
			changeBlockType(subwayDistance, 0, 1,Material.RAIL);
		    }
		else if ((Math.floor((actualDistance + 1) / 12) * 12) == (actualDistance + 1)) {
			changeBlockType(subwayDistance, 0,-1,Material.RAIL);
			changeBlockType(subwayDistance, 0, 1,Material.RAIL);
		    }
		else {
			if ((Math.floor(actualDistance / 6) * 6) == actualDistance) {
				changeBlockType(subwayDistance, 0,-1,Material.POWERED_RAIL);
			    changeBlockType(subwayDistance, 0, 1,Material.POWERED_RAIL);
			    }
			else if ((Math.floor((actualDistance - 1) / 6) * 6) == (actualDistance - 1)) {	
				if (subwayDirection == NORTH) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }	
				    }
				else if (subwayDirection == SOUTH) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }	
				    }
				else if (subwayDirection == EAST) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
				else if (subwayDirection == WEST) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
			    }
			else if ((Math.floor((actualDistance + 1) / 6) * 6) == (actualDistance + 1)) {
				if (subwayDirection == NORTH) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
				else if (subwayDirection == SOUTH) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
				else if (subwayDirection == EAST) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
				else if (subwayDirection == WEST) {
					if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
						changeBlockType(subwayDistance, 0,-1,Material.RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
					else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.RAIL);
					    }	
					else {
						changeBlockType(subwayDistance, 0,-1,Material.DETECTOR_RAIL);
						changeBlockType(subwayDistance, 0, 1,Material.DETECTOR_RAIL);
					    }
				    }
			    }
			else {
				changeBlockType(subwayDistance, 0,-1,Material.RAIL);
			    changeBlockType(subwayDistance, 0, 1,Material.RAIL);
			    }
		    }
		
		/* fix fences hanging in mid air */
		if ((solidBlock(getBlockType(subwayDistance, 2,-2)) && (airBlock(getBlockType(subwayDistance, 1,-2))))) {
			changeBlockType(subwayDistance, 1,-2,Material.IRON_BARS);
		    }
		if ((solidBlock(getBlockType(subwayDistance, 2, 2)) && (airBlock(getBlockType(subwayDistance, 1, 2))))) {
			changeBlockType(subwayDistance, 1, 2,Material.IRON_BARS);
		    }
		if ((getBlockType(subwayDistance, 1,-2) == Material.IRON_BARS) && (airBlock(getBlockType(subwayDistance, 0,-2)))) {
			changeBlockType(subwayDistance, 0,-2,Material.IRON_BARS);
		    }
		if ((getBlockType(subwayDistance, 1, 2) == Material.IRON_BARS) && (airBlock(getBlockType(subwayDistance, 0, 2)))) {
			changeBlockType(subwayDistance, 0, 2,Material.IRON_BARS);
		    }
						
		/* install minecart teleporters along track */ 
		if (fast) {
			Block myBlock = null;
			BlockState myState = null;
			CommandBlock myCommandBlock = null;
			String commandString = null;
			if (subwayDirection == NORTH) {
				if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1,-1); 
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1, 1);
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~-10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    }
				else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1, 1); 
					    myBlock.setType(Material.COMMAND_BLOCK); 
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1,-1);
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~-10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
					    }
				    }
			    }
			else if (subwayDirection == SOUTH) {
				if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1, 1); 
					    myBlock.setType(Material.COMMAND_BLOCK); 
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1,-1);
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~-10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    }
				else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1,-1); 
					    myBlock.setType(Material.COMMAND_BLOCK); 
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1, 1);
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~ ~1 ~-10 ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
					    }
				    }
			    }
			else if (subwayDirection == EAST) {
				if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1,-1); 
					    myBlock.setType(Material.COMMAND_BLOCK);
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1, 1);
					    myBlock.setType(Material.COMMAND_BLOCK);
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~-10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    }
				else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1, 1); 
					    myBlock.setType(Material.COMMAND_BLOCK);
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1,-1);
					    myBlock.setType(Material.COMMAND_BLOCK);
						myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~-10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();                               
					    }
				    }
			    }
			else if (subwayDirection == WEST) {
				if ((subwayRegion == UK) || (subwayRegion == JAPAN)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1, 1); 
					    myBlock.setType(Material.COMMAND_BLOCK); 
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1,-1);
					    myBlock.setType(Material.COMMAND_BLOCK);
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~-10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    }
				else if ((subwayRegion == USA) || (subwayRegion == CANADA)) {
				    if ((Math.floor((actualDistance - 2) / 12) * 12) == (actualDistance - 2)) {
  					    myBlock = getBlock(subwayDistance, 0,-1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
  					    myBlock = getBlock(subwayDistance,-1,-1);  
					    myBlock.setType(Material.COMMAND_BLOCK); 
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
				        }
				    else if ((Math.floor((actualDistance + 2) / 12) * 12) == (actualDistance + 2)) {
  					    myBlock = getBlock(subwayDistance, 0, 1); 
					    myBlock.setType(Material.DETECTOR_RAIL); 
 					    myBlock = getBlock(subwayDistance,-1, 1);
					    myBlock.setType(Material.COMMAND_BLOCK);
					    myState = myBlock.getState();
						myCommandBlock = (CommandBlock) myState;
						commandString = "/tp @e[type=minecart,sort=nearest,limit=1] ~-10 ~1 ~ ";
						myCommandBlock.setCommand(commandString);  
						myCommandBlock.update();
					    }
				    }
			    }
		    }
				
		/* clear debris above track */ 		
		Material thingy = null;
		boolean climbing = false;
		column = -2;
		while (column <= 2) {
			climbing = true;
			height = 3;
			while (climbing) {
				if (absoluteY(height) > buildPlayer.getWorld().getMaxHeight()) {
					climbing = false;
				    }
				else {					
					thingy = getBlockType(subwayDistance,height,column);
					if (thingy == Material.BEDROCK) {
						climbing = false;						
					    }
					else if (thingy == Material.ACACIA_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.BIRCH_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.DARK_OAK_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.JUNGLE_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.OAK_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.SPRUCE_LOG) {
						clearBlockType(subwayDistance,height,column,Material.AIR);
					    }
					else if (thingy == Material.BUBBLE_COLUMN) { 
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.KELP) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.KELP_PLANT) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.SEAGRASS) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.TALL_SEAGRASS) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.TUBE_CORAL) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.BRAIN_CORAL) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.BUBBLE_CORAL) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.FIRE_CORAL) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.HORN_CORAL) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }					
					else if (thingy == Material.TUBE_CORAL_FAN) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.BRAIN_CORAL_FAN) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.BUBBLE_CORAL_FAN) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.FIRE_CORAL_FAN) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy == Material.HORN_CORAL_FAN) {
						clearBlockType(subwayDistance,height,column,Material.WATER);
					    }
					else if (thingy.isAir()) {
						climbing = false;
					    }
					else if (thingy == Material.AIR) {
						climbing = false;
					    }
					else if (liquidBlock(thingy)) {
						climbing = false;
					    }
				    }			
				height = height + 1;
			    }
			column = column + 1;
		    }
		
		/* remove blocks floating in mid air above track */
		column = -2;
		while (column <= 2) {
			if (solidBlock(getBlockType(subwayDistance, 2, column)) && (airBlock(getBlockType(subwayDistance, 2,(column - 1)))) && (airBlock(getBlockType(subwayDistance, 2,(column + 1))))) {
				climbing = true;
				height = 3;
				while (climbing) {
					if (height > buildPlayer.getWorld().getMaxHeight()) {
						climbing = false;
					    }
					else {
						Material material = getBlockType(subwayDistance,height,column);
						if ((material.isAir()) || (material == Material.BEDROCK)) {
						    climbing = false;
						    }
						else {
							height = height + 1;
						    }
				        }
				    }		
				height = height - 1;
				while (height >= 2) {
					changeBlockType(subwayDistance,height,column,Material.AIR);
					height = height - 1;
				    }
			    }
			column = column + 1;
		    }				
		
		/* place supports under the track */
		if (bridgeStyle == CONCRETE) {
			sinking = false;
			thing = null;
		    if (snapPoint) {
		    	column = -1;								
				while (column <= 1) {
					if (buildPlayer.getWorld().getBlockAt(absoluteX(subwayDistance,column),1,absoluteZ(subwayDistance,column)).getType() != Material.AIR) {						
						sinking = true;
						height = -2;
						while (sinking) {
							if (absoluteY(height) < 1) {
								sinking = false;
							    }
							else {
								thing = getBlockType(subwayDistance,(height - 1),column);
								if (thing == Material.BEDROCK) {
									changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
									sinking = false;
						            }
								else if (thing == Material.LAVA) {
									changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
						            }
								else if (plantMatter(thing)) {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
								    }
								else if (liquidBlock(thing)) {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
						            }				
								else if (thing.isAir()) {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
								    }
								else if (thing.hasGravity()) {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
						            }
								else if (solidBlock(thing)) {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
									sinking = false;
						            }
								else {
									changeBlockType(subwayDistance,height,column,Material.WHITE_CONCRETE);
								    }						    	
							    }
							height = height - 1;
						    }
					    }
					column = column + 1;
				    }
		        }						
	        }
		else if (bridgeStyle == IRON) {
			sinking = false;
			thing = null;
		    if (snapPoint || snapPoint_1) {
		    	column = -2;								
				while (column <= 2) {
					if (buildPlayer.getWorld().getBlockAt(absoluteX(subwayDistance,column),1,absoluteZ(subwayDistance,column)).getType() != Material.AIR) {						
						if ((column == -2) || (column == -1) ||  (column == 2) || (column == 1)) {
							sinking = true;
							height = -2;
							while (sinking) {
								if (absoluteY(height) < 1) {
									sinking = false;
								    }
								else {
									thing = getBlockType(subwayDistance,(height - 1),column);
									if (thing == Material.BEDROCK) {
										changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
										sinking = false;
							            }
									else if (thing == Material.LAVA) {
										changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
							            }
									else if (plantMatter(thing)) {
										changeBlockType(subwayDistance,height,column,Material.IRON_BARS);
									    }
									else if (liquidBlock(thing)) {
										changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
							            }				
									else if (thing.isAir()) {
										changeBlockType(subwayDistance,height,column,Material.IRON_BARS);
									    }
									else if (thing.hasGravity()) {
										changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							            }
									else if (solidBlock(thing)) {
										changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
										sinking = false;
							            }
									else {
										changeBlockType(subwayDistance,height,column,Material.IRON_BARS);
									    }						    	
								    }
								height = height - 1;
							    }
						    }

					    }										
					column = column + 1;
				    }
		        }						
			}
		else if (bridgeStyle == STONE) {
			sinking = false;
			thing = null;
		    if (snapPoint || snapPoint_1) {
		    	column = -2;								
				while (column <= 2) {
					if (buildPlayer.getWorld().getBlockAt(absoluteX(subwayDistance,column),1,absoluteZ(subwayDistance,column)).getType() != Material.AIR) {					
						sinking = true;
						height = -2;
						while (sinking) {
							if (absoluteY(height) < 1) {
								sinking = false;
							    }
							else {
								thing = getBlockType(subwayDistance,(height - 1),column);
								if (thing == Material.BEDROCK) {
									changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
									sinking = false;
						            }
								else if (thing == Material.LAVA) {
									changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
						            }
								else if (plantMatter(thing)) {
									changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
								    }
								else if (liquidBlock(thing)) {
									changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
						            }				
								else if (thing.isAir()) {
									changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
								    }
								else if (thing.hasGravity()) {
									changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						            }
								else if (solidBlock(thing)) {
									changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
									sinking = false;
						            }
								else {
									changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
								    }						    	
							    }
							height = height - 1;
						    }
					    }					
					column = column + 1;
				    }
		        } 
		    else if (snapPoint_2) {
		    	column = -2;								
				while (column <= 2) {
					if (buildPlayer.getWorld().getBlockAt(absoluteX(subwayDistance,column),1,absoluteZ(subwayDistance,column)).getType() != Material.AIR) {						
						sinking = true;
						height = -2;
						while ((sinking) && (height >= -3)) {
							thing = getBlockType(subwayDistance,(height - 1),column);
							if (thing == Material.BEDROCK) {
								changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
								sinking = false;
					            }
							else if (thing == Material.LAVA) {
								changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
					            }
							else if (plantMatter(thing)) {
								changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							    }
							else if (liquidBlock(thing)) {
								changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
					            }				
							else if (thing.isAir()) {
								changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							    }
							else if (thing.hasGravity()) {
								changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
					            }
							else if (solidBlock(thing)) {
								changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
								sinking = false;
					            }
							else {
								changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							    }						    	
							height = height - 1;
						    }
						//if (sinking) {
						//    changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
						//    }
					    }										
					column = column + 1;
				    }
		        }
		    else if (snapPoint_3) {
		    	column = -2;								
				while (column <= 2) {
					sinking = true;
					height = -2;
					while ((sinking) && (height >= -2)) {
						thing = getBlockType(subwayDistance,(height - 1),column);
						if (thing == Material.BEDROCK) {
							changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
							sinking = false;
				            }
						else if (thing == Material.LAVA) {
							changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
				            }
						else if (plantMatter(thing)) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }
						else if (liquidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
				            }				
						else if (thing.isAir()) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }
						else if (thing.hasGravity()) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
				            }
						else if (solidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							sinking = false;
				            }
						else {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }						    	
						height = height - 1;
					    }
					//if (sinking) {
					//    changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
					//    }
					column = column + 1;
				    }
		        }
		    else if (snapPoint_4) {
		    	column = -2;								
				while (column <= 2) {
					sinking = true;
					height = -1;
					while ((sinking) && (height >= -1)) {
						thing = getBlockType(subwayDistance,(height - 1),column);
						if (thing == Material.BEDROCK) {
							changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
							sinking = false;
				            }
						else if (thing == Material.LAVA) {
							changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
				            }
						else if (plantMatter(thing)) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }
						else if (liquidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
				            }				
						else if (thing.isAir()) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }
						else if (thing.hasGravity()) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
				            }
						else if (solidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							sinking = false;
				            }
						else {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
						    }						    	
						height = height - 1;
					    }					
					//if (sinking) {
					//    changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
					//    }
					column = column + 1;
				    }
		        }
		    /*
		    else if (snapPoint_5) {
		    	column = -2;	
				height = -1;
				while (column <= 2) {
					thing = getBlockType(subwayDistance,(height - 1),column);
					if (thing == Material.BEDROCK) {
						changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
						sinking = false;
			            }
					else if (thing == Material.LAVA) {
						changeBlockType(subwayDistance,height,column,Material.OBSIDIAN);
			            }
					else if (plantMatter(thing)) {
						changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
					    }
					else if (liquidBlock(thing)) {
						changeBlockType(subwayDistance,height,column,Material.MOSSY_STONE_BRICKS);
			            }				
					else if (thing.isAir()) {
						changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
					    }
					else if (thing.hasGravity()) {
						changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
			            }
					else if (solidBlock(thing)) {
						changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
						sinking = false;
			            }
					else {
						changeBlockType(subwayDistance,height,column,Material.STONE_BRICK_STAIRS);
					    }						    	
					column = column + 1;
				    }
		        }
		    /* */
		    }
		else if (bridgeStyle == WOOD) {
			sinking = false;
			thing = null;
			column = -1;
			while (column <= 1) {
				sinking = true;
				height = -2;
				while (sinking) {
					if (absoluteY(height) < 1) {
						sinking = false;
					    }
					else {
						thing = getBlockType(subwayDistance,(height - 1),column);
						if (thing == Material.BEDROCK) {
							changeBlockType(subwayDistance,height,column,Material.STONE_BRICKS);
							sinking = false;
				            }
						else if (thing == Material.LAVA) {
							changeBlockType(subwayDistance,height,column,Material.COBBLESTONE);
				            }
						else if (plantMatter(thing)) {
							changeBlockType(subwayDistance,height,column,Material.OAK_FENCE);
						    }
						else if (liquidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.MOSSY_COBBLESTONE);
				            }				
						else if (thing.isAir()) {
							changeBlockType(subwayDistance,height,column,Material.OAK_FENCE);
						    }
						else if (thing.hasGravity()) {
							changeBlockType(subwayDistance,height,column,Material.COBBLESTONE);
				            }
						else if (solidBlock(thing)) {
							changeBlockType(subwayDistance,height,column,Material.COBBLESTONE);
							sinking = false;
				            }
						else {
							changeBlockType(subwayDistance,height,column,Material.OAK_FENCE);
						    }
					    }
					height = height - 1;
				    }
				column = column + 1;
			    }
			}		
	    }
	
	private void removeSand(int subwayDistance, int subwayHeight, int subwayColumn) {
		if (getBlockType(subwayDistance,subwayHeight,subwayColumn).hasGravity()) {
			int newHeight = subwayHeight;
			boolean climbing = true;
			while (climbing) {
				if (newHeight > buildPlayer.getWorld().getMaxHeight()) {
					climbing = false;
				    }
				else {
					Material material = getBlockType(subwayDistance,newHeight,subwayColumn);
					if ((material.hasGravity()) || (material.isAir()) || (plantMatter(material)) || (material == Material.BEDROCK)) {
					    newHeight = newHeight + 1;
					    }
					else {
						climbing = false;
					    }
			        }
			    }		
			newHeight = newHeight - 1;
			while (newHeight >= subwayHeight) {
			    if (getBlockType(subwayDistance,newHeight,subwayColumn).hasGravity()) {
				    clearBlockType(subwayDistance,newHeight,subwayColumn,Material.DIRT);
			        }
				newHeight = newHeight - 1;
			    }
		    }
	    }
		
	private boolean airBlock(Material material) {
		boolean yesNo = false;
		if (material.isAir()) {
			yesNo = true;
		    }
		else if (material == Material.AIR) {
			yesNo = true;
		    }
		else if (plantMatter(material)) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private boolean plantMatter(Material material) {
		boolean yesNo = false;
		if (material == Material.ACACIA_LOG) {
			yesNo = true;
		    }
		else if (material == Material.BIRCH_LOG) {
			yesNo = true;
		    }
		else if (material == Material.DARK_OAK_LOG) {
			yesNo = true;
		    }
		else if (material == Material.JUNGLE_LOG) {
			yesNo = true;
		    }
		else if (material == Material.OAK_LOG) {
			yesNo = true;
		    }
		else if (material == Material.SPRUCE_LOG) {
			yesNo = true;
		    }
		else if (material == Material.ACACIA_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.BIRCH_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.DARK_OAK_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.JUNGLE_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.OAK_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.SPRUCE_LEAVES) {
			yesNo = true;
		    }
		else if (material == Material.CACTUS) {
			yesNo = true;
		    }
		else if (material == Material.SUGAR_CANE) {
			yesNo = true;
		    }
		else if (material == Material.BAMBOO) {
			yesNo = true;
		    }
		else if (material == Material.POPPY) {
			yesNo = true;
		    }
		else if (material == Material.GRASS) {
			yesNo = true;
		    }
		else if (material == Material.TALL_GRASS) {
			yesNo = true;
		    }
		else if (material == Material.DEAD_BUSH) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private boolean railBlock(Material material) {
		boolean yesNo = false;
		if (material == Material.RAIL) {
			yesNo = true;
		    }
		else if (material == Material.POWERED_RAIL) {
			yesNo = true;
		    }
		else if (material == Material.DETECTOR_RAIL) {
			yesNo = true;
		    }
		else if (material == Material.ACTIVATOR_RAIL) {
			yesNo = true;
		    }
		else if (material == Material.IRON_BARS) {
			yesNo = true;
		    }
		else if (material == Material.REDSTONE_TORCH) {
			yesNo = true;
		    }
		else if (material == Material.REPEATER) {
			yesNo = true;
		    }
		else if (material == Material.COMPARATOR) {
			yesNo = true;
		    }
		else if (material == Material.COMMAND_BLOCK) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private boolean solidBlock(Material material) {
		boolean yesNo = false;
		if (airBlock(material)) {
			yesNo = false;
		    }
		else if (liquidBlock(material)) {
			yesNo = false;
		    }
		else if (material.isSolid()) {
			yesNo = true;
		    }				
		return (yesNo);
	    }
	
	private boolean waterPlant(Material material) {
		boolean yesNo = false;
		if (material == Material.KELP) {
			yesNo = true;
		    }
		else if (material == Material.KELP_PLANT) {
			yesNo = true;
		    }
		else if (material == Material.SEAGRASS) {
			yesNo = true;
		    }
		else if (material == Material.TALL_SEAGRASS) {
			yesNo = true;
		    }
		else if (material == Material.TUBE_CORAL) {
			yesNo = true;
		    }
		else if (material == Material.BRAIN_CORAL) {
			yesNo = true;
		    }
		else if (material == Material.BUBBLE_CORAL) {
			yesNo = true;
		    }
		else if (material == Material.FIRE_CORAL) {
			yesNo = true;
		    }
		else if (material == Material.HORN_CORAL) {
			yesNo = true;
		    }					
		else if (material == Material.TUBE_CORAL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.BRAIN_CORAL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.BUBBLE_CORAL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.FIRE_CORAL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.HORN_CORAL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.TUBE_CORAL_WALL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.BRAIN_CORAL_WALL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.BUBBLE_CORAL_WALL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.FIRE_CORAL_WALL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.HORN_CORAL_WALL_FAN) {
			yesNo = true;
		    }
		else if (material == Material.BUBBLE_COLUMN) {
			yesNo = true;
		    }
		return (yesNo);
	    }

	private boolean waterBlock(Material material) {
		boolean yesNo = false;
		if (material == Material.WATER) {
			yesNo = true;
		    }
		else if (material == Material.ICE) {
			yesNo = true;
		    }
		else if (material == Material.PACKED_ICE) {
			yesNo = true;
		    }
		else if (material == Material.BLUE_ICE) {
			yesNo = true;
		    }
		else if (waterPlant(material)) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private boolean liquidBlock(Material material) {
		boolean yesNo = false;
		if (material == Material.LAVA) {
			yesNo = true;
		    }
		else if (waterBlock(material)) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private boolean glassBlock(Material material) {
		boolean yesNo = false;
		if (material == Material.GLASS) {
			yesNo = true;
		    }
		else if (material == Material.BLACK_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.BLUE_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.BROWN_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.CYAN_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.GRAY_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.GREEN_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.LIGHT_BLUE_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.LIGHT_GRAY_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.LIME_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.MAGENTA_STAINED_GLASS) {
			yesNo = true;
		    }		
		else if (material == Material.ORANGE_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.PINK_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.PURPLE_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.RED_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.YELLOW_STAINED_GLASS) {
			yesNo = true;
		    }
		else if (material == Material.WHITE_STAINED_GLASS) {
			yesNo = true;
		    }
		return (yesNo);
	    }
	
	private int absoluteDistance(int distancePos) {
		int actual = 0;
		if (subwayDirection == NORTH) {
			actual = distanceStart - distancePos; 
		    }
		else if (subwayDirection == SOUTH) {
			actual = distanceStart + distancePos;
		    }
		else if (subwayDirection == EAST) {
			actual = distanceStart + distancePos;
		    }
		else if (subwayDirection == WEST) {
			actual = distanceStart - distancePos;
		    }
		else {
			logger.severe("[" + pdfFile.getName() + "] Invalid direction in absoluteDistance(). ");
		    }
		return (actual);
	    }
	
	private int absoluteX(int distancePos, int centerPos) {
		int actualX = 0;
		if (subwayDirection == NORTH) {
			actualX = centerStart - centerPos;
		    }
		else if (subwayDirection == SOUTH) {
			actualX = centerStart + centerPos;
		    }
		else if (subwayDirection == EAST) {
			actualX = distanceStart + distancePos;
		    }
		else if (subwayDirection == WEST) {
			actualX = distanceStart - distancePos;
		    }
		else {
			logger.severe("[" + pdfFile.getName() + "] Invalid direction in absoluteX(). ");
		    }
		return(actualX);
	    }
	
	private int absoluteY(int elevationPos) {
		int actualY = subwayY + elevationPos;
		return(actualY);
	    }
	
	private int absoluteZ(int distancePos, int centerPos) {
		int actualZ = 0;
		if (subwayDirection == NORTH) {
			actualZ = distanceStart - distancePos;
		    }
		else if (subwayDirection == SOUTH) {
			actualZ = distanceStart + distancePos;
		    }
		else if (subwayDirection == EAST) {
			actualZ = centerStart + centerPos;
		    }
		else if (subwayDirection == WEST) {
			actualZ = centerStart - centerPos;
		    }
		else {
			logger.severe("[" + pdfFile.getName() + "] Invalid direction in absoluteZ(). ");
		    }
		return(actualZ);
	    }
	
	private void tpPlayer(int distancePos, int altitudePos, int centerPos) {		
		Location destination = buildPlayer.getLocation();
		destination.setX(absoluteX(distancePos,centerPos));
		destination.setY(absoluteY(altitudePos));
		destination.setZ(absoluteZ(distancePos,centerPos));
		buildPlayer.setFlying(false);
		buildPlayer.setSneaking(false);
		buildPlayer.teleport(destination);
	    }
	
    private Block getBlock(int distancePos, int altitudePos, int centerPos) {
    	Block block = null;
		int blockX = absoluteX(distancePos,centerPos);
		int blockY = absoluteY(altitudePos);
		int blockZ = absoluteZ(distancePos,centerPos);
		block = buildPlayer.getWorld().getBlockAt(blockX,blockY,blockZ);
    	return (block);
        }
    
    private Material getBlockType(int distancePos, int altitudePos, int centerPos) {
    	Block block = null;
		block = getBlock(distancePos,altitudePos,centerPos);
    	return (block.getType());
        }
    
    private void changeBlockType(int distancePos, int altitudePos, int centerPos, Material material) {    	
    	Block block = null;
		block = getBlock(distancePos,altitudePos,centerPos);
		block.setType(material);
		insertBlock(block);
        }
    
    private void clearBlockType(int distancePos, int altitudePos, int centerPos, Material material) {
    	Block block = null;
		block = getBlock(distancePos,altitudePos,centerPos);
		block.setType(material);
        }
    
    @EventHandler (priority = EventPriority.LOW)
    public void playerQuitEventHandler(PlayerQuitEvent event) {
    	Player player = event.getPlayer();
    	if (player.equals(buildPlayer)) {
    	    if (building) {
			    building = false;
    	        }
    	    }
        }
    
    @EventHandler (priority = EventPriority.LOW) 
    public void blockFromToEventHandler (BlockFromToEvent event) {
		if (queryProtectedLocation(event.getBlock().getLocation())) {
			event.setCancelled(true);
		    }
		if (queryProtectedLocation(event.getToBlock().getLocation())) {
			event.setCancelled(true);
	        }
	    }    
    
    @EventHandler (priority = EventPriority.LOW) 
    public void blockPlaceEventHandler (BlockPlaceEvent event) {
		if (protection > 0) {
			Block block = event.getBlock();
			if (queryProtectedLocation(block.getLocation())) {
				if (block.getType() == Material.MINECART) {
					return;
				    }
				else {
					Player player = event.getPlayer();
					if (player.isOp()) {
						if (opStick(player)) {
							return;
						    }
						else {
						    event.getPlayer().sendMessage("<SUBWAY> You must be weilding your OP Stick to work on the railroad. ");
			    		    event.setCancelled(true);
						    }
					    }
					else {
					    event.getPlayer().sendMessage("<SUBWAY> The subway is protected from griefing. ");
		    		    event.setCancelled(true);
					    }
				    }
			    }
		    }
	    }  

	@EventHandler (priority = EventPriority.LOW)
    public void blockBreakEventHandler(BlockBreakEvent event) {
		if (protection > 0) {
			Block block = event.getBlock();
			if (queryProtectedLocation(block.getLocation())) {
				if ((block.getType().hasGravity() || (block.getType() == Material.MINECART))) {
					return;
				    }
				else {
					Player player = event.getPlayer();
					if (player.isOp()) {
						if (opStick(player)) {
							return;
						    }
						else {
						    event.getPlayer().sendMessage("<SUBWAY> You must be weilding your OP Stick to work on the railroad. ");
						    event.setCancelled(true);
						    }
					    }
					else {
					    event.getPlayer().sendMessage("<SUBWAY> The subway is protected from griefing. ");
					    event.setCancelled(true);
					    }
				    }
			    }
		    }
   	    }    
	
    @EventHandler (priority = EventPriority.LOW)
    public void entityInteractEventHandler (EntityInteractEvent event) {
		if (protection > 0) {
			Block block = event.getBlock();
			if (queryProtectedLocation(block.getLocation())) {
	   			event.setCancelled(true);  
	            }
		    }
        }  
	
    @EventHandler (priority = EventPriority.LOW) 
    public void playerBucketEmptyEventHandler (PlayerBucketEmptyEvent event) {
		if (protection > 0) {
	    	if (queryProtectedLocation(event.getBlockClicked().getLocation())) {
	    		Player player = event.getPlayer();
	    		player.sendMessage("<SUBWAY> Don't empty that bucket in the subway! ");  
			    event.setCancelled(true);
	        	}
		    }
	    } 
    
    @EventHandler (priority = EventPriority.LOW)
    public void entityExplodeEventHandler (EntityExplodeEvent event) {
		if (protection > 0) {
	    	if (event.isCancelled() == false) {
	            List<Block> blocks = event.blockList();
	            Block block = null;
	            Location location = null; 
	            int index = blocks.size() - 1;
	            while (index >= 0) {        	
	            	block = blocks.get(index);
	            	location = block.getLocation();
	            	if (queryProtectedLocation(location)) {
	            		blocks.remove(index); 
	            	    }
	            	index = index - 1;
	                }
	    	    }
		    }
        }  
    
    @EventHandler (priority = EventPriority.LOW)
    public void blockExplodeEventHandler (BlockExplodeEvent event) {
		if (protection > 0) {
			if (queryProtectedLocation(event.getBlock().getLocation())) {
	   		    event.setCancelled(true);
			    }
		    }
        }  	
    
    @EventHandler (priority = EventPriority.LOW) 
    public void blockDamageEventHandler (BlockDamageEvent event) {
    	if ((protection > 1) && (building == false)) {
    		Block block = event.getBlock();
    		if (queryProtectedLocation(block.getLocation())) {
    			if ((block.getType().hasGravity() || (block.getType() == Material.MINECART))) {
    				return;
    			    }
    			else {
    				Player player = event.getPlayer();
    				if (player.isOp()) {
    					if (opStick(player)) {
    						return;
    					    }
    					else {
    					    event.getPlayer().sendMessage("<SUBWAY> You must be weilding your OP Stick to work on the railroad. ");
    		    		    event.setCancelled(true);
    					    }
    				    }
    				else {
    				    event.getPlayer().sendMessage("<SUBWAY> The subway is protected from griefing. ");
    	    		    event.setCancelled(true);
    				    }
    			    }
    		    }
    	    }
   	    }   

    @EventHandler (priority = EventPriority.LOW)
    public void blockSpreadEventHandler (BlockSpreadEvent event) {
    	if ((protection > 1) && (building == false)) {
            if (queryProtectedLocation(event.getBlock().getLocation())) {
            	if (event.getBlock().getType() == Material.WATER) {
       	     		event.setCancelled(true);  
            	    }
            	else if (event.getBlock().getType() == Material.LAVA) {
       	     		event.setCancelled(true);  
            	    }
            	event.setCancelled(true);
                }
    	    }
        }
 
    @EventHandler (priority = EventPriority.LOW) 
    public void blockIgniteEventHandler (BlockIgniteEvent event) {    	
		if (queryProtectedLocation(event.getBlock().getLocation())) {
   		    event.setCancelled(true);
		    }
	    }
    
    @EventHandler (priority = EventPriority.LOW)
    public void creatureSpawnEventHandler (CreatureSpawnEvent event) {
    	if ((protection > 1) && (building == false)) {
    		if (queryProtectedLocation(event.getLocation())) {
            	if (event.getEntity() instanceof Monster) {
            	 	event.setCancelled(true);  
            	    }
            	else if (event.getEntity().hasAI()) {
            		event.setCancelled(true);  
            	    }
    		    }    	
    	    }
        }

    @EventHandler (priority = EventPriority.LOW)
    public void entityDamageByEntityEventHandler (EntityDamageByEntityEvent event) {
    	if ((protection > 1) && (building == false)) {
    		if (queryProtectedLocation(event.getEntity().getLocation())) {
    			if (event.getDamager() != null) {
    				if (event.getDamager() instanceof Player) {
    					Player player1 = (Player) event.getDamager();
    					if (event.getEntity() != null) {
    						if (event.getEntity() instanceof Player) {
    							Player player2 = (Player) event.getEntity();
    							player1.sendMessage("<SUBWAY> No fighting in the subway! ");
    							player2.sendMessage("<SUBWAY> No fighting in the subway! ");
    							event.setCancelled(true);
    	   				        }
    					    }
    				    }
    				else {
    					event.getDamager().remove();
    				    }					
       			    }
       		    }    		
    	    }
   		}
        
    @EventHandler (priority = EventPriority.LOW)
    public void entityShootBowEventHandler (EntityShootBowEvent event) {
    	if ((protection > 1) && (building == false)) {
        	if (queryProtectedLocation(event.getEntity().getLocation())) {
            	if (event.getEntity() instanceof Player) {
        			Player player = (Player) event.getEntity();
        			player.sendMessage("<SUBWAY> No fighting in the subway! ");
            	    }
            	event.setCancelled(true);
                }
    	    }
        }
    
    @EventHandler (priority = EventPriority.LOW)
    public void explosionPrimeEventHandler (ExplosionPrimeEvent event) {
    	if ((protection > 1) && (building == false)) {
        	if (queryProtectedLocation(event.getEntity().getLocation())) {
        		if (event.getEntity() instanceof Player) {
        			Player player = (Player) event.getEntity();
        			player.sendMessage("<SUBWAY> No terrorism in the subway! ");
            	    }
           		event.setCancelled(true);  
                }
    	    }
        }
    
    @EventHandler (priority = EventPriority.LOW) 
    public void hangingPlaceEventHandler (HangingPlaceEvent event) {
    	if ((protection > 1) && (building == false)) {
        	if (queryProtectedLocation(event.getEntity().getLocation())) {
        		Player player = event.getPlayer();
    			player.sendMessage("<SUBWAY> You can't hang that in the subway! ");
    			event.setCancelled(true);      		
        	    }
    	    }
	    }   
        
    @EventHandler (priority = EventPriority.LOW)
    public void lightningStrikeEventHandler (LightningStrikeEvent event) {
    	if ((protection > 1) && (building == false)) {
        	if (queryProtectedLocation(event.getLightning().getLocation())) {
           		event.setCancelled(true);  
                }
    	    }
        }
   
    @EventHandler (priority = EventPriority.LOW)
    public void potionSplashHanler (PotionSplashEvent event) {
    	if ((protection > 1) && (building == false)) {
    		Collection<LivingEntity> livingEntities = event.getAffectedEntities();
    		Player player = null;
    		if (livingEntities.isEmpty() == false) {
    			LivingEntity entity[] = livingEntities.toArray(new LivingEntity[livingEntities.size()]);
    			int entityIndex = 0;
    		    while (entityIndex < entity.length) {
    		    	if (entity[entityIndex] instanceof Player) {
    		    		player = (Player) entity[entityIndex];
    		    		if (queryProtectedLocation(player.getLocation())) {
    		    			entity[entityIndex].remove();   
        				    }
    		    	    }
    		    	entityIndex = entityIndex + 1;
    		        }
    		    }		
    	    }    	
        }    
    
    @EventHandler (priority = EventPriority.LOW)
    public void playerInteractHandler (PlayerInteractEvent event) {
    	Player player = event.getPlayer();
    	if (event.getClickedBlock() != null) {
    		Block clickedBlock = event.getClickedBlock();
    		if (((clickedBlock.getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE)) || (clickedBlock.getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE))  {
    			Location location = clickedBlock.getLocation();
    	    	int playerX = location.getBlockX();
    	    	int playerY = location.getBlockY();
    	    	int playerZ = location.getBlockZ();
    	    	boolean giveBook = false;
        	    if ((player.getWorld().getBlockAt((playerX + 1),playerY,playerZ).getType() == Material.IRON_BLOCK) && (player.getWorld().getBlockAt((playerX - 1),playerY,playerZ).getType() == Material.IRON_BLOCK)) {
        	    	if ((glassBlock(player.getWorld().getBlockAt((playerX + 1),(playerY + 1),playerZ).getType())) && (glassBlock(player.getWorld().getBlockAt((playerX - 1),(playerY + 1),playerZ).getType()))) {
        	    		giveBook = true;    	    		
        	    	    }
        	        }
        	    if ((player.getWorld().getBlockAt(playerX,playerY,(playerZ + 1)).getType() == Material.IRON_BLOCK) && (player.getWorld().getBlockAt(playerX,playerY,(playerZ - 1)).getType() == Material.IRON_BLOCK)) {
        	    	if ((glassBlock(player.getWorld().getBlockAt(playerX,(playerY + 1),(playerZ + 1)).getType())) && (glassBlock(player.getWorld().getBlockAt(playerX,(playerY + 1),(playerZ - 1)).getType()))) {
        	    		giveBook = true;    	    		
        	    	    }
        	        }
    	    	if (giveBook) {
    			   	boolean found = false;
    				Inventory inventory = player.getInventory();  
    				int inventoryIx = inventory.getSize() - 1;
    				while (inventoryIx >= 0) {
    					if (inventory.getItem(inventoryIx) != null) {
    						ItemStack item = inventory.getItem(inventoryIx);
    						if (item.getType() == Material.WRITTEN_BOOK) { 
    						    BookMeta bookMeta = (BookMeta) item.getItemMeta();
    						    int loreIx = 0;
    						    List<String> loreList = bookMeta.getLore();
    						    while (loreIx < loreList.size()) {				    
    						        String lore = loreList.get(loreIx);
    						        if (lore.equalsIgnoreCase(pdfFile.getName())) {
    						        	found = true;
    						        	inventoryIx = 0;
    						            }
    						        loreIx = loreIx + 1;
    						        }
    						    }
    					    }
    					inventoryIx = inventoryIx - 1;
    				    }
    				if (found == false) {
    			    	location = player.getLocation();
    			    	if (giveBook) {
    					    if (bookFileName != null) {
    					    	String rawBook = readBook(bookFileName, player);
    			            	String bookText = scanBook(rawBook);
    			            	long fileDate = getFileDate(bookFileName);
    			    			String title = getTitle(bookText);
    			                String author = getAuthor(bookText);
    			                String bookPages[] = formatBook(bookText, fileDate);
    			                ItemStack myBook = createBook(title, author, bookPages);	
    			                giveItemToPlayer(player, myBook, title);
    			                logger.info("[" + pdfFile.getName() + "] Gave book '" + bookFileName + "' to player '" + player.getName() + "'. ");
    					        }
    			    	    }
    				    }    		    		
    	    	    }
    	        } 
    		else if (queryProtectedLocation(clickedBlock.getLocation())) {
    			if (protection > 0) {
        			if (player.isOp()) {
        				if (opStick(player)) {
        					return;
        				    }
        				else {
        				    event.getPlayer().sendMessage("<SUBWAY> You must be weilding your OP Stick to work on the railroad. ");
        				    event.setCancelled(true);
        				    }
        			    }
        			else {
        			    event.getPlayer().sendMessage("<SUBWAY> The subway is protected from griefing. ");
        			    event.setCancelled(true);
        			    }
    			    }
                }
		    }		
        }
            
    private String getFileName(String bookName) {
    	String fileName = null;
		String searchName = null;
		File dir = null;
	    File files[] = null;
	    File file = null;
	    int index = 0;
        fileName = null;
        boolean found = false;
 	    dir = new File("."); 
 		files = dir.listFiles();
        index = 0;
        searchName = "";
        while (index < files.length) {
            file = files[index];
         	if (file.isFile()) {
         		searchName = file.getName();
         		if (searchName.equalsIgnoreCase("BOOK(" + bookName + ").TXT")) {
         			found = true;
         			fileName = searchName;
         		    }	                	
         	    }
         	index = index + 1;
            }
        if (found == false) {
        	logger.warning("[" + pdfFile.getName() + "] File 'BOOK(" + bookName + ").TXT' does not exist. ");
            }
        return(fileName);
	    }
    
	private String readBook(String fileName, Player plr) {
		File bookFile = null;	
		BufferedReader reader = null;
		String recordBuffer = null;
		String fullText = null;
		bookFile = new File(fileName);
	    if (bookFile.exists()) {	    	
	    	try {
	    		fullText = "";
	    		reader = new BufferedReader(new FileReader(fileName));	    			    		
	    		recordBuffer = reader.readLine();   
	    		while (recordBuffer != null) {
	    			if (recordBuffer.length() > 0) {
	    				fullText = fullText.trim() + " " + recordBuffer.trim();
	    			    }	
	    			recordBuffer = reader.readLine();
	    		    }
	    	    }
			catch (IOException oops) {
				logger.severe("[" + pdfFile.getName() + "] Problem with file '" + fileName + "'. ");			
				fullText = null;
			    }				
	    	finally {
	    		try {
	    		    reader.close();
	    		    }
	    		catch (IOException oops) {
	    			logger.severe("[" + pdfFile.getName() + "] Problem with file '" + fileName + "'. ");
	    			fullText = null;
		    	    }
	    	    }	    	
	        }	        
	    else {
	    	logger.severe("[" + pdfFile.getName() + "] Problem with file '" + fileName + "'. ");
	    	fullText = null;
	        }
	    return (fullText);
	    }
    
    private String scanBook (String bookIn) {
		String bookOut = "";
		char bookChar = ' ';
		int index = 0;
		while (index < bookIn.length()) {
			bookChar = bookIn.charAt(index);
			if (bookChar == '"') {
				bookOut = bookOut + "\\" + bookChar; 
			    }
			else if (bookChar == '\\') {
				bookOut = bookOut + "\\" + bookChar; 
			    }
			else {
				bookOut = bookOut + bookChar;
			    }
			index = index + 1;
		    }
		return (bookOut);		
	    }    
    
    private long getFileDate(String fileName) {				
		File bookFile = null;
		long fileDate = 0;
		bookFile = new File(fileName);
		fileDate = 0;
	    if (bookFile.exists()) {	    			
		    fileDate = bookFile.lastModified();
	        }
		return(fileDate);
	    }
	
	private String getTitle(String fullText) {
		String wordArray[] = null;  
		String word = null;
		int wordIndex = 0;
		String code = null;
		char mode = ' ';
		String title = null;
		wordArray = fullText.split("\\s\\s*");
		wordIndex = 0;	
		title = "";
		while (wordIndex < wordArray.length) {
			word = wordArray[wordIndex].trim();				
			if (word.startsWith("^")) {
				if (word.length() > 1) {
					code = word.substring(1, 2);
					if (code.equalsIgnoreCase("T")) {
						title = "";
						mode = 'T';
						wordArray[wordIndex] = "";
				        }
					else {
						mode = ' ';
					    }
				    }										
			    }
			else if (mode == 'T') {
				if (title.length() == 0) {
				    title = word;					   
				    }
				else {
					title = title + " " + word;
				    }
				wordArray[wordIndex] = "";
			    }
			wordIndex = wordIndex + 1;
		    }	
		return (title);
	    }
	
	private String getAuthor(String fullText) {
		String wordArray[] = null;  
		String word = null;
		int wordIndex = 0;
		String code = null;
		char mode = ' ';
		String author = null;
		wordArray = fullText.split("\\s\\s*");
		wordIndex = 0;	
		author = "";
		while (wordIndex < wordArray.length) {
			word = wordArray[wordIndex].trim();				
			if (word.startsWith("^")) {
				if (word.length() > 1) {
					code = word.substring(1, 2);
					if (code.equalsIgnoreCase("A")) {
						author = "";
						mode = 'A';
						wordArray[wordIndex] = "";
				        }
					else {
						mode = ' ';
					    }
				    }										
			    }
			else if (mode == 'A') {
				if (author.length() == 0) {
				    author = word;					   
				    }
				else {
					author = author + " " + word;
				    }
				wordArray[wordIndex] = "";
			    }
			wordIndex = wordIndex + 1;
		    }
		return (author);
	    }
	
	private String[] formatBook(String fullText, long bookDate) {		
		String wordArray[] = null;  
		String word = null;
		int wordIndex = 0;
		String code = null;
		char mode = ' ';
		String title = null;
		String author = null;
		String pages[] = null;
		String titleWords[] = null;
		int titleIndex = 0;
		String authorWords[] = null;
		int authorIndex = 0;
		int fillerNeeded = 0;
		String by = "by";
		boolean newPage = false;
		int currentPage = 0;
		int lineCount = 0;
		int linecenter = 0;
		int nextcenter = 0;
		SimpleDateFormat sdf = null;
		String prettyDate = null;		
		Date myDate = null;
		int arrayLength = 0;
		int controlIndex = 0;
		wordArray = fullText.split("\\s\\s*");
		wordIndex = 0;	
		title = "";
		author = "";
		while (wordIndex < wordArray.length) {
			word = wordArray[wordIndex].trim();				
			if (word.startsWith("^")) {
				if (word.length() > 1) {
					code = word.substring(1, 2);
					if (code.equalsIgnoreCase("T")) {
						title = "";
						mode = 'T';
						wordArray[wordIndex] = "";
				        }
					else if (code.equalsIgnoreCase("A")) {
						author = "";
						mode = 'A';
						wordArray[wordIndex] = "";
			            }
					else {
						mode = ' ';
					    }
				    }										
			    }
			else if (mode == 'T') {
				if (title.length() == 0) {
				    title = word;					   
				    }
				else {
					title = title + " " + word;
				    }
				wordArray[wordIndex] = "";
			    }
			else if (mode == 'A') {
				if (author.length() == 0) {
				    author = word;
				    }
				else {
					author = author + " " + word;
				    }
				wordArray[wordIndex] = "";
			    }
			wordIndex = wordIndex + 1;
		    }	
		wordIndex = 0;
		pages = new String[1];
		pages[0] = " " + CRLF + CRLF;		
		if (textcenter(title) <= pagecenter) {
			fillerNeeded = pagecenter - textcenter(title);
			pages[0] = pages[0] + spaces(fillerNeeded / 2) + title + CRLF;		
		    }
		else {
			titleWords = title.split(" ");
			titleIndex = 0;
			while (titleIndex < titleWords.length) {
				fillerNeeded = pagecenter - textcenter(titleWords[titleIndex]);
				pages[0] = pages[0] + spaces(fillerNeeded / 2) + titleWords[titleIndex] + CRLF;				
				titleIndex = titleIndex + 1;
			    }			
		    }
		if (author.length() > 0) {
			pages[0] = pages[0] + CRLF;		
			fillerNeeded = pagecenter - textcenter(by);
			pages[0] = pages[0] + spaces(fillerNeeded / 2) + by + CRLF;					
			if (author.length() <= pagecenter) {
				fillerNeeded = pagecenter - textcenter(author);
				pages[0] = pages[0] + spaces(fillerNeeded / 2) + author + CRLF;
			    }
			else {
				authorWords = author.split(" ");
				authorIndex = 0;
				while (authorIndex < authorWords.length) {
					fillerNeeded = pagecenter - textcenter(authorWords[authorIndex]);
					pages[0] = pages[0] + spaces(fillerNeeded / 2) + authorWords[authorIndex] + CRLF;				
					authorIndex = authorIndex + 1;
				    }			
			    }			
		    }		
		if (bookDate > 0) {
			pages[0] = pages[0] + CRLF;
			myDate = new java.sql.Date(bookDate);					 		   
			sdf = new SimpleDateFormat("dd-MMM-yyyy"); 
			prettyDate = sdf.format(myDate);
			fillerNeeded = pagecenter - textcenter(prettyDate);
			pages[0] = pages[0] + spaces(fillerNeeded / 2) + prettyDate; 		
		    }			
		pages = createNewPage(pages);
		newPage = true;
		currentPage = pages.length - 1;	
		lineCount = 1;
		wordIndex = 0;
		while (wordIndex < wordArray.length) {
			controlIndex = wordIndex;
			if (textcenter(wordArray[wordIndex]) > pagecenter) {
				arrayLength = wordArray[wordIndex].length();
				while (textcenter(subString(wordArray[wordIndex], 0, arrayLength)) > pagecenter) {
				    arrayLength = arrayLength - 1;
				    }
				arrayLength = arrayLength - 1;
				word = subString(wordArray[wordIndex], 0, arrayLength) + "-";
				wordArray[wordIndex] = subString(wordArray[wordIndex], arrayLength, wordArray[wordIndex].length() - arrayLength);
			    }
			else {
				word = wordArray[wordIndex].trim();
				wordIndex = wordIndex + 1;
			    }
			if (word.length() > 0) {
				if (word.startsWith("^")) {
					if (word.length() > 1) {
						code = word.substring(1, 2);
						if (code.equalsIgnoreCase("C")) {
							mode = 'C';
							if (!newPage) {
								pages = createNewPage(pages);
								newPage = true;
								linecenter = 0;
								lineCount = 1;
								currentPage = pages.length - 1;	
							    }							
						    }
						else if (code.equalsIgnoreCase("P")) {
							pages[currentPage] = pages[currentPage] + CRLF + CRLF;
							linecenter = 0;
							lineCount = lineCount + 2;
						    }
						else if (code.equalsIgnoreCase("B")) {
							pages[currentPage] = pages[currentPage] + CRLF;
							linecenter = 0;
							lineCount = lineCount + 1;
						    }
						else {
							mode = ' ';
						    }
					    }
					else {
						mode = ' ';
					    }
					wordArray[controlIndex] = "";
				    }
				else {
					if (word.contains("%")) {
						word = hexDecode(word);
					    }
					nextcenter = textcenter(word) + textcenter(" ");
					if (linecenter + nextcenter > pagecenter) {
						while ((pages[currentPage].endsWith(" ")) && (pages[currentPage].length() > 1)) {
							pages[currentPage] = subString(pages[currentPage], 0, pages[currentPage].length() - 1);							
						    }
						pages[currentPage] = pages[currentPage] + CRLF;  
						linecenter = 0;
						lineCount = lineCount + 1;						
					    }
					if (lineCount > PageLines) {
						pages = createNewPage(pages);
						newPage = true;
						currentPage = pages.length - 1;
						linecenter = 0;
						lineCount = 1;
					    }
					else if (pages[currentPage].length() >= (pageChars - 4)) {
						pages = createNewPage(pages);
						newPage = true;
						currentPage = pages.length - 1;
						linecenter = 0;
						lineCount = 1;
					    }
					pages[currentPage] = pages[currentPage] + word + " ";
					linecenter = linecenter + nextcenter;
					newPage = false;
				    }
			    }			
		    }		
		return (pages);
	    }
	
	private String spaces(int filler) {
		String spaces = "";		
		while (filler > 0) {
			spaces = spaces + " ";			
			filler = filler - 4;
		    }
		return (spaces);
	    }
	
	private int textcenter(String word) {			
		int count = 0;
		int index = 0;
		char myChar = ' ';
		
		count = 0;
		index = 0;		
		while (index < word.length()) {
			myChar = word.charAt(index);
			if (myChar == 'I') {
				count = count + 4; 
			    }
			else if (myChar == 'i') {
				count = count + 2; 
			    }
			else if (myChar == 'l') {
				count = count + 3; 
			    }
			else if (myChar == '+') {
				count = count + 3; 
			    }
			else if (myChar == 'f') {
				count = count + 5; 
			    }
			else if (myChar == 'k') {
				count = count + 2; 
			    }
			else if (myChar == '@') {
				count = count + 7; 
			    }
			else if (myChar == '~') {
				count = count + 7; 
			    }
			else if (myChar == ' ') {
				count = count + 4; 
			    }
			else if (myChar == ',') {
				count = count + 2; 
			    }
			else if (myChar == '.') {
				count = count + 2; 
			    }
			else if (myChar == '|') {
				count = count + 2; 
			    }
			else if (myChar == ':') {
				count = count + 2; 
			    }
			else if (myChar == ';') {
				count = count + 2; 
			    }
			else if (myChar == '!') {
				count = count + 2; 
			    }
			else if (myChar == '`') {
				count = count + 3; 
			    }
			else if (myChar == '\'') {
				count = count + 3; 
			    }
			else if (myChar == '"') {
				count = count + 5; 
			    }
			else if (myChar == '*') {
				count = count + 5; 
			    }
			else if (myChar == '(') {
				count = count + 5;				
			    }
			else if (myChar == ')') {
				count = count + 5; 
			    }
			else if (myChar == '{') {
				count = count + 5;				
			    }
			else if (myChar == '}') {
				count = count + 5; 
			    }
			else if (myChar == '[') {
				count = count + 4;				
			    }
			else if (myChar == ']') {
				count = count + 4; 
			    }
			else {
				count = count + 6;
			    }
			index = index + 1;
		    }		    			
		return(count);
	    }	
		
	private String subString(String stringIn, int start, int length) {
		int stringLength = 0;
		stringLength = start + length;
		if (stringLength > stringIn.length()) {
			stringLength = stringIn.length();
		    }
	    String stringOut = stringIn.substring(start, stringLength);		
		return(stringOut);
	    }
		
	private String[] createNewPage(String[] oldPages) {
		int newPage = oldPages.length + 1;
		String newPages[] = new String[newPage];
		int pageIndex = 0;
		
		pageIndex = 0;
		while (pageIndex < oldPages.length) {
			newPages[pageIndex] = oldPages[pageIndex];
			pageIndex = pageIndex + 1;
		    }
		newPages[pageIndex] = "";
		return (newPages);
	    }
	
	private ItemStack createBook(String title, String author, String page[]) {
    	ItemStack myBook = new ItemStack(Material.WRITTEN_BOOK);
    	BookMeta bookMeta = (BookMeta) myBook.getItemMeta();
    	bookMeta.setTitle(title);
        bookMeta.setAuthor(author);
		List<String> loreList = Arrays.asList(pdfFile.getName());				    						    	
	    bookMeta.setLore(loreList); 
        int pageIx = 0;
        List<String> bookPages = new ArrayList<String>();
        if (page.length > 0) {
        	pageIx = 0;
        	while (pageIx < page.length) {
        		bookPages.add(pageIx, page[pageIx]);
        		pageIx = pageIx + 1;
        	    }
            }	
        bookMeta.setPages(bookPages);
    	myBook.setItemMeta(bookMeta);	    		    	
		return (myBook);
	    }
	
	private void giveItemToPlayer(Player player, ItemStack item, String title) {
		PlayerInventory inventoryList = player.getInventory();
    	if (inventoryList.getItemInMainHand().getAmount() == 0) {
    		inventoryList.setItemInMainHand(item);
    		player.updateInventory();
    		player.sendMessage("<SUBWAY> " + bookMessage); 
    	    }
    	else if (inventoryList.getItemInOffHand().getAmount() == 0) {
    		inventoryList.setItemInOffHand(item);
    		player.updateInventory();    		
    		player.sendMessage("<SUBWAY> " + bookMessage);    	
    	    }
    	else {
    		boolean searching = true;
    		int invIx = 0;
    		while (searching) {
    		    if (invIx >= inventoryList.getSize()) {
    		    	player.sendMessage("<SUBWAY> You have no empty inventory slots!");
		        	searching = false;
    		        }
    		    else {
    		    	if (inventoryList.getItem(invIx) == null) {
        				inventoryList.setItem(invIx, item);
        	    		player.updateInventory();    				    
        	    		player.sendMessage("<SUBWAY> " + bookMessage);
        				searching = false;
    		            }    		    	 
    			    }    			
    			invIx = invIx + 1;
    		    }
    	    }
	    }	
	
	private void doNothing() { }
	
    }
