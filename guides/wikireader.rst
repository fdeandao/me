setting up the debian installation
----------------------------------

::

	su
	apt-get install sudo
	gpasswd -a wikireader sudo
	visudo # add rule for your user
	exit
	bash
	sudo apt-get install vim flex bison ocaml python python-gd gforth guile-1.8 gawk php5-cli php5-sqlite sqlite3 xfonts-utils cjk-latex dvipng qt4-qmake libqt4-dev sudo wget git-core build-essential mecab mecab-naist-jdic php5-tidy python-mecab python-lzma
	git clone https://github.com/wikireader/wikireader.git
	cd wikireader
	make all
	make all # yes twice
	vim samo-lib/include/config.h # uncomment the define for BOARD_SAMO_V1 or V2
	make all
	mkdir -p image/enpedia work/enpedia work/tmp/enpedia

make the following change::

	diff --git a/host-tools/offline-renderer/Makefile b/host-tools/offline-renderer/Makefile
	index 819fce2..c55c434 100644
	--- a/host-tools/offline-renderer/Makefile
	+++ b/host-tools/offline-renderer/Makefile
	@@ -74,7 +74,7 @@ VERSION_FILE := ${DATA_PREFIX}.ftr
	 MECAB_INDEX := $(shell for d in /usr/lib/mecab /usr/libexec/mecab /usr/bin; do f="$${d}/mecab-dict-index"; [ -x "$${f}" ] && echo $${f} && bre
	 
	 # search for the mecab dictionary directory
	-MECAB_DICT_DIR := $(shell for d in /var/lib/mecab/dic/ipadic-utf8 /usr/lib64/mecab/dic/ipadic; do [ -d "$${d}" ] && echo $${d} && break; done)
	+MECAB_DICT_DIR := $(shell for d in /var/lib/mecab/dic/naist-jdic/ /var/lib/mecab/dic/ipadic-utf8 /usr/lib64/mecab/dic/ipadic; do [ -d "$${d}" 
	 
	 # options for the dictionary index program
	 MECAB_INDEX_OPTS := --dicdir="${MECAB_DICT_DIR}" --charset=utf-8 --dictionary-charset=utf-8

kind of script::

	make XML_FILES='XML-Licenses/de/license.xml XML-Licenses/de/terms.xml hitchwiki-en.xml' WORKDIR=work DESTDIR=image WIKI_LANGUAGE=de WIKI_DIR_SUFFIX=hitch  cleandirs createdirs iprc
