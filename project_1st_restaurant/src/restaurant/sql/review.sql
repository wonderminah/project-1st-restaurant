drop sequence rv_seq;
create sequence rv_seq;
create table review
(
	id        number(2) primary key,
	nickname  varchar(15),
	storename varchar(30),
	grade     number(1),
	text      varchar(90) not null
);

insert into review values (rv_seq.nextval, '±è¹Î¾Æ', '±³ÃÌÄ¡Å²', 1, 'Àú´Â ±Á³×Ä¡Å²ÀÌ ÁÁ½À´Ï´Ù.');
insert into review values (rv_seq.nextval, '²¿²¿', '±³ÃÌÄ¡Å²', 5, '¾öÃ» ¸ÀÀÖ¾î¿ä Â¯Â¯');
insert into review values (rv_seq.nextval, '¼öÁø¾²', '±³ÃÌÄ¡Å²', 3, '±³ÃÌÀÌ¾ß ¹¹ Ç×»ó ¹«³­ÇÏÁÒ');
insert into review values (rv_seq.nextval, '¿õÀÌ', '±Á³×Ä¡Å²', 3, '¾çÀº Á» ÀÛÁö¸¸ ¸ÀÀº ÁÁ¾Æ¿ä');
insert into review values (rv_seq.nextval, 'sci***', '±Á³×Ä¡Å²', 5, 'º¼ÄÉÀÌ³ë´Â »ç¶û');
insert into review values (rv_seq.nextval, '¸À³ª±¸¸¸', '±Á³×Ä¡Å²', 4'¸ÀÀÖ¾î¿ä');
insert into review values (rv_seq.nextval, '¯ƒÈò', '±Á³×Ä¡Å²', 4, 'º¼ÄÉÀÌ³ë´Â ²À µå¼¼¿ä °­Ãß');
insert into review values (rv_seq.nextval, 'buf***', '³×³×Ä¡Å²', 3, '±â¸§ ±ú²ıÇÏ°í ¸ÀÀÖ³×¿ä');
insert into review values (rv_seq.nextval, 'ddy***', '³×³×Ä¡Å²', 4, '¾çµµ ¸¹°í ÁÁ¾Æ¿ä ´ÙÀ½¿¡µµ ½ÃÅ³°Ô¿ä');
insert into review values (rv_seq.nextval, '³×±â', '³×³×Ä¡Å²', 5, '¿ª½Ã ½º³ëÀ® Ä¡Å² ');
insert into review values (rv_seq.nextval, '¸ÀÀß¾Ë', '³×³×Ä¡Å²', 4, 'Æ¢±è¿ÊÀÌ ¹Ù»è¹Ù»èÇØ¼­ ÁÁÀ½');
insert into review values (rv_seq.nextval, '³»°¡ÂÇ¿ä', '³×³×Ä¡Å²', 4, '¸ÀÀÖ°í ¹è´Ş¿øµµ Ä£Àı ÇÏ½Ê´Ï´Ù');
insert into review values (rv_seq.nextval, 'Çàº¹ÀÌ', 'ÇÇÀÚÇê', 4, 'Ä¡Áîµµ ÂßÂß ´Ã¾î³ª°í Àß ¸Ô¾ú¾î¿ä');
insert into review values (rv_seq.nextval, 'ppp***', 'ÇÇÀÚÇê', 1, '»çÀÌ´Ù ½ÃÄ×´Âµ¥ ÆÕ½Ã·Î ¿Ô¾î¿ä');
insert into review values (rv_seq.nextval, 'scn***', 'ÆÄÆÄÁ¸½º', 3, 'Àß ¸Ô°Ú½À´Ï´Ù');
insert into review values (rv_seq.nextval, 'zzi***', 'ÆÄÆÄÁ¸½º', 5, '»çÀå´Ô ³Ê¹« ÇÏ½Å°Å ¾Æ´Õ´Ï±î Á¸¸À');
insert into review values (rv_seq.nextval, '‡œ‡œ', 'ÆÄÆÄÁ¸½º', 1, '°¥¸¯µğÇÎ¼Ò½º Ãß°¡ ÇØ´Ş¶ó°í Çß´Âµ¥ ¾È¿Ô¾î¿ä');
insert into review values (rv_seq.nextval, 'ioo***', 'ÆÄÆÄÁ¸½º', 5, '¸ÀÀÖ³×¿ä Á¶¸¸°£ ÀçÁÖ¹® ÇÒµí¿ä');
insert into review values (rv_seq.nextval, 'zar***', 'ÆÄÆÄÁ¸½º', 4, '¿À´Ãµµ ¸ÀÀÖ¾î¿ä');
insert into review values (rv_seq.nextval, 'ooo***', 'ÆÄÆÄÁ¸½º', 4, 'ÀÏ¿äÀÏÀº ÆÄÆÄÁ¸½º');
insert into review values (rv_seq.nextval, 'mzm***', '¹Ì½ºÅÍÇÇÀÚ', 4, '¸ÀÀÖÀ½');
insert into review values (rv_seq.nextval, 'sid***', '¹Ì½ºÅÍÇÇÀÚ', 4, 'ÇÇÀÚÇê¸¸ ½ÃÄÑ¸Ô´Ùº¸´Ï ½É½ÉÇÑ ¸ÀÀÌÁö¸¸ ¸ÔÀ»¸¸ÇÔ');
insert into review values (rv_seq.nextval, 'º¸½º', '¹Ì½ºÅÍÇÇÀÚ', 4, '´ÙÀ½¿¡ ¶Ç ½ÃÅ³°Ô¿ä');
insert into review values (rv_seq.nextval, 'raa***', '¹Ì½ºÅÍÇÇÀÚ', 5, 'ÀÏ¿äÀÏÀº ¿ª½Ã ¹Ì½ºÅÍÇÇÀÚ');
insert into review values (rv_seq.nextval, '¹äÁà', 'ÃÖ°íÁıÁ·¹ß', 4, '¾ç ¸¹¾Æ¿ä');
insert into review values (rv_seq.nextval, 'ÆÎÆÎ', 'ÃÖ°íÁıÁ·¹ß', 5, '´Ü°ñ µÉ°Å °°¾Æ¿ä ¸À³ª¿ä');
insert into review values (rv_seq.nextval, 'mil***', 'ÀåÃæµ¿Á·¹ß', 5, '¾öÃ» ¹èÅÍÁö°Ô ¸Ô¾ú³×¿ä');
insert into review values (rv_seq.nextval, 'zzn***', 'ÀåÃæµ¿Á·¹ß', 5, 'ÃÖ°í¿¹¿ä ¸Àµµ ÁÁÀºµ¥ °¡°İµµ ÂøÇÔ');
insert into review values (rv_seq.nextval, '¤·¤·¤¸', 'ÀåÃæµ¿Á·¹ß', 5, '¸®ºäº¸°í ½ÃÄ×´Âµ¥ ¸À³ª¿ä');
insert into review values (rv_seq.nextval, 'cut***', 'ÀåÃæµ¿Á·¹ß', 5, 'Á¤¸» ¸ÀÀÖ³×¿ä');
insert into review values (rv_seq.nextval, 'gar***', 'Á·¹ßÀÇ³ª¶ó', 5, 'µ¿³× »ì¸é ´Ù ¾Æ´Â ¸ÀÁı ¿À·£¸¸¿¡ ¸Ô¾îµµ ¸À³²');
insert into review values (rv_seq.nextval, 'pri***', 'Á·¹ßÀÇ³ª¶ó', 3, '¹«»ıÃ¤µµ ±âº»À¸·Î ³Ö¾îÁÖ¼ÌÀ¸¸é');
insert into review values (rv_seq.nextval, 'kak***', 'Á·¹ßÀÇ³ª¶ó', 5, 'Ç×»ó Á·¹ß ½ÃÅ³¶§ ¿©±â·Î ½ÃÅµ´Ï´Ù');
insert into review values (rv_seq.nextval, 'hoh***', 'Á·¹ßÀÇ³ª¶ó', 3, 'Àú¹ø¿¡ ¸ÀÀÖ¾î¼­ ÁÖ¹® Çß´Âµ¥ ¿À´Ã Á» ³¿»õ³ª³×¿ä');
insert into review values (rv_seq.nextval, '¸¶³ó', 'Á·¹ßÀÇ³ª¶ó', 3, '°¨»çÇÕ´Ï´Ù');
insert into review values (rv_seq.nextval, 'Çª¿ì¾¾', '¹Ì½ºÅÍº¸½Ó', 4, '³¿»õµµ ¾È³ª°í ºÎµå·´°í ¸À³ª¿ä');
insert into review values (rv_seq.nextval, 'bab***', '¹Ì½ºÅÍº¸½Ó', 4, '¸ÔÀ»¸¸ÇØ¿ä »ı¸¶´Ã ´õ ÁÖ¸é ÁÁÀ»°Å °°À½');
insert into review values (rv_seq.nextval, 'ÀÚÃë»ı', '¹Ì½ºÅÍº¸½Ó', 5, '¼­ºñ½ºÄİ¶ó Àß ¸¶¼Ì½À´Ï´Ù');
insert into review values (rv_seq.nextval, 'guu***', '¹Ì½ºÅÍº¸½Ó', 4, '±ò²ûÇß¾î¿ä');
insert into review values (rv_seq.nextval, 'fff***', '¿øÇÒ¸Åº¸½Ó', 4, 'µû¶æÇØ¼­ ¸ÀÀÖ¾î¿ä');
insert into review values (rv_seq.nextval, 'rui***', '¿øÇÒ¸Åº¸½Ó', 1, 'Ã³À½ ½ÃÄÑºÃ´Âµ¥ ¤²¤©');
insert into review values (rv_seq.nextval, 'lin***', '¿øÇÒ¸Åº¸½Ó', 3, '¸ÀÀÖ°Ô Àß ¸Ô¾ú¾î¿ä');
insert into review values (rv_seq.nextval, 'bik***', '¼­°¡³×º¸½Ó', 4, 'ÇÇ°ïÇß´Âµ¥ ¸Ô°í ÇÇ°ïÀÌ Ç®¸²');
insert into review values (rv_seq.nextval, 'ÁÁ¾Æ¿ä', '¼­°¡³×º¸½Ó', 4, '´ã¿¡µµ ¶Ç ½ÃÅ³°Ô¿ä');
