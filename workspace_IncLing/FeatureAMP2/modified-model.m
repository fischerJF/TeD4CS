FEATUREAMP___ : GUI___ PLAYER___+ :: _FEATUREAMP___ ;

GUI___ : TIME___+ [SHOWCOVER___] [PLAYLIST___] [VOLUMECONTROL___] SKINS___ :: _GUI___ ;

TIME___ : SHOWTIME___
	| PROGRESSBAR___ ;

PLAYLIST___ : LOADFOLDER___ CONTROLPLAYIST___* [SAVEANDLOADPLAYLIST___] [QUEUETRACK___] [CLEARPLAYLIST___]:: _PLAYLIST___ ;

CONTROLPLAYIST___ : SKIPTRACK___
	| SHUFFLEREPEAT___
	| REMOVETRACK___
	| REORDERPLAYLIST___ ;

VOLUMECONTROL___ : [MUTE___] :: _VOLUMECONTROL___ ;

SKINS___ : LIGHTSKIN___
	| DARKSKIN___ ;

PLAYER___ : MP3___
	| OGG___ ;



%%

PLAYLIST___ implies PROGRESSBAR___ ;
CLEARPLAYLIST___ implies REMOVETRACK___ ;