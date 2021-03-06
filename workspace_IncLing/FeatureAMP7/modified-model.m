FEATUREAMP___ : GUI___ AUDIOFORMATS___+ [OPENWAVFILE___] :: _FEATUREAMP___ ;

GUI___ : [VOLUMECONTROL___] OPENFILE___ TIME___+ [PLAYLIST___] SKINS___ :: _GUI___ ;

VOLUMECONTROL___ : [MUTE___] :: _VOLUMECONTROL___ ;

TIME___ : SHOWTIME___
	| PROGRESSBAR___ ;

PLAYLIST___ : LOADFOLDER___ CHANGEPLAYLIST___* [SAVEANDLOADPLAYLIST___] [QUEUETRACK___] [CLEARPLAYLIST___] :: _PLAYLIST___ ;

CHANGEPLAYLIST___ : SHUFFLEREPEAT___
	| SKIPTRACK___
	| REMOVETRACK___
	| REORDERPLAYLIST___ ;


SKINS___ : LIGHT___
	| DARK___
	| ORANGEBLUEST___ ;

AUDIOFORMATS___ : [SHOWTITLE___] OPENMP3FILE___ [SHOWCOVER___] :: MP3PLAYER___
	| WAVPLAYER___ ;


%%

OPENMP3FILE___ implies OPENFILE___ ;
PLAYLIST___ implies PROGRESSBAR___ ;
CLEARPLAYLIST___ implies REMOVETRACK___ ;
OPENWAVFILE___ implies WAVPLAYER___;

