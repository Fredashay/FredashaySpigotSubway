    This plugin builds subways across your world.  It's really easy to use.  In the chat window, type:
  
        /SUBWAY X=n Y=n Z=n D=N|S|E|W L=n   
        
    You could also spell things out if that's what warps your starship:
    
        /SUBWAY X=n Y=n Z=n DIRECTION=NORTH|SOUTH|EAST|WEST LENGTH=n
    
    n is any number.  The plugin will give you an error message if n is out of range for the parameter.

    If all the parameters are valid, the plugin will build a subway starting at X,Y,Z coords in the
specified direction for a length of n blocks.  It will build the subway in the dimension you are
currently in, be it the World, the Nether, the End, or a custom world.

    The plugin slices time to build the subway, so you can continue playing while the subway is being
built without freezing up the server.  You will notice there's a split second pause as it builds each
slice of subway tunnel.  It may take a long time to build a long rail line.

    If you specify, for example, X=* Y=* or Z=*, the plugin will use your current location for these
values.  If you specify DIRECTION=*, the plugin will build in the direction you are facing, as long
as you are facing directly North, South, East or West.  

    If your subway is above ground level, support pillars will be placed every 6 blocks under the
tracks to create an E.L.  They will extend downward until they touch solid ground.  
If the tracks are over water or lava, the support pillars will extend down into the water or lava 
until they reach solid ground.  But if there is no solid ground, such as in The End, there will 
be no support pillar.

    If your subway passes through a mountain, tunnel walls will be built around it.  

    WARNING!  The plugin doesn't detect houses, villages, temples, fortresses, strongholds, portals,  
sunken ships, mansions, or other players' bases, etc.  It will build the subway through anything in 
the way.  Survey your route by eye in Spectator mode before you build!

    PROPERTIES FILE
    
    This plugin creates a subway.properties file the first time it runs.  The properties file contains
several default settings for region and tunnel styles.     
     If the properties file specifies REGION=USA or REGION=CANADA, the detectors will be placed ahead 
of the powered rails on the right hand side, so that minecarts will accelerate on the right side and 
be stopped on the left.  If you specify REGION=UK or REGION=JAPAN, the reverse will be true.

    If the properties file specifies ALIGNMENT=, subway lines will be snap to the nearest parallel
multiple of that value.  The default is 6.  For example, if you specify X=13 and Z=8, the plugin 
will assume you mean X=12 and Z=6.  This is so that when subways cross, they will intersect without 
oddly placed lamp posts and support pillars.
   
    If the properties file specifies TUNNEL=, this tells the plugin what style you want for your 
tunnels. The options are CONCRETE or IRON or STONE or WOOD.

    If the properties file specifies BRIDGE=, this tells the plugin what style you want for your 
bridges and elevated lines. The options are CONCRETE or IRON or STONE or WOOD.

    If the properties file specifies BOOK=, this tells the plugin the name of the transit guide 
book that it gives to a player whenever he passes through a turnstile, or requests a copy of the
book.  The default value is SUBWAY.  See TRANSIT GUIDE below.  

    If the properties file specifies MESSAGE=, this tells the plugin to send a message to the player
whenever he is given a SUBWAY book.  The default message is, "Thank you for riding Fred A. Rapid
Transit!"  You may want to change this.

    If the properties file specifies FAST=TRUE, this tells the plugin to place command blocks
under the tracks every so often to accelerate the minecarts beyond their normal game speed.  This
may be useful if you have a ginormous world with far-flung stations.   If you wish, you may change
the commands in the command blocks to teleport the minecarts directly to the next station without
breaking the plugin.  You may also want to issue the command: /gamerule commandBlockOutput false 
or you'll be nagged constantly whenever someone uses the subway.

    Lastly, if you keep the plugin loaded on your server after you build all your subways, it 
will protect the subway tracks from griefing and hostile mobs. 

    STATIONS 

    What about stations, you ask?  There are so many opinions regarding stations that I'll
never please everyone with a one-size-fits-all station.  Some people want an automated station
that destroys and stores arriving minecarts and dispenses new ones.  Other people want a simple
"train station platform" that the carts move past slowly.  Yet other people want a programmable
system where the player dials their destination and the station dispenses a minecart for them.
I can't please everyone, so I won't even try.  You have to build your own stations.

    TRANSIT GUIDE
    
    This plugin will give the player a transit guide book when he passes through a turnstile.
This feature requires that you also have my BOOK plugin installed.  The book must be in your
main server directory and be named "BOOK(SUBWAY).TXT".  Instructions are in my BOOK plugin
describing how to format the file to be turned into a Minecraft written book by the plugin.  
 
    Because turnstiles can come in many shapes and features, I have settled on one particular
design that I use on my server.  My turnstiles are two iron blocks resting on the floor with a 
glass block on top of each of the iron blocks and a gold or iron pressure plate on the floor 
between these objects.  The plugin will detect whenever a player steps on a gold or iron pressure 
plate and then check for the iron blocks and glass blocks adjacent to the pressure plate.  If it 
detects a turnstile when the player steps on the pressure plate, it will give the player a 
transit guide book if he doesn't already have one.  A turnstile can be oriented east/west or 
north/south.  Here's a diagram from the view entering the turnstile:

    +-----+     +-----+     
    |glass|     |glass|
    |block|     |block|  
    +-----+     +-----+
    |iron |     |iron |
    |block| === |block|   That === is a pressure plate on the floor.
 ---+-----+-----+-----+---   
           floor
           
    KNOWN BUGS
    
    If one subway line crosses another, the plugin doesn't know what you intend to happen and it
gets confused, especially if the two lines aren't at the same Y height.  You'll have to clean 
things up and connect the track the way you want.      

    It also gets confused when building a tunnel through a cave where the ground is below the
track level.  Do I build a tunnel here, or a bridge?  ¯\_(ツ)_/¯

    Trees are a problem!  The plugin will try to prune trees in a sensible manner along the 
tracks so that you don't see trees simply sliced in half or mangled along the way, or leaves 
floating in mid-air, but it isn't perfect, such as when the tree-itself isn't in the way but
the leaves hang over the right-of-way, or visa-versa.  The Minecraft game engine usually notices
clumps of leaves floating in mid-air and lets them despawn naturally, but not always.  So you 
will have to do some manual editing along the way.  Sorry...

    Water is also a problem.  Sometimes a subway will intersect some water and the water will start 
flowing after the plugin removed the existing block but before it placed the tracks.  That may 
result in some water flowing onto the tracks. 

    Sometimes, the subway will disturb loose sand above.  Since sand falls in slow motion relative
to game ticks, it will land on the subway after that slice has been built and the plugin has moved
on, and so the plugin won't detect it.  So some clean-up may be necessary.  This usually occurs at 
tunnel entrances in deserts or if the subway passes through a cave or canyon.

    Also, while this may be obvious, building a subway on a busy server may cause your players
to complain about "lag."  Best to build your subways late at night when nobody is playing.

    GO AHEAD AND TRY IT!

    I recommend you play around with this plugin on a test server before building subways
on your live server.  Try building elevated lines, underground tunnels, underwater tunnels, 
and surface lines, all with each of the different styles.  Also mix and match different
styles, for example, iron bridges with concrete tunnels for a New York City look, or concrete 
bridges with stone tunnels for a European look.  
