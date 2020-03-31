FEATUREAMP___ : CHOOSEFILE___ PLAYENGINE___ GUI___ :: _FEATUREAMP___ ;

CHOOSEFILE___ : FILESUPPORT___+ :: _CHOOSEFILE___ ;

FILESUPPORT___ : WAV___
	| OGG___
	| MP3___ ;

GUI___ : TRACKTIME___+ [VOLUMECONTROL___] [PLAYLIST___] [SHOWCOVER___] SKINS___  [CLEARPLAYLIST___] :: _GUI___ ;

TRACKTIME___ : SHOWTIME___
	| PROGRESSBAR___ ;

VOLUMECONTROL___ : [MUTE___] :: _VOLUMECONTROL___ ;

PLAYLIST___ : LOADFOLDER___ CONTROL___+ [SAVEANDLOADPLAYLIST___] [QUEUETRACK___] :: _PLAYLIST___ ;

CONTROL___ : SKIPTRACK___
	| SHUFFLEREPEAT___
	| REMOVETRACK___
	| REORDERPLAYLIST___ ;


SKINS___ : LIGHT___
	| DARK___ ;

%%

PLAYLIST___ implies PROGRESSBAR___ ;
CLEARPLAYLIST___ implies REMOVETRACK___ ;