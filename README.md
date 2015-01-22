CommonUtils
===========

Extra Utilities For Collections,Array and String

Maven Dependecies
==================

This jar depends on apache's commons-lang3-3.1, apache's commons-collection 3 and junit 4.

The maven dependencies can be resolved by adding following maven dependency in your pom file before using this jar.

	<dependency>
		<groupId>commons-collections</groupId> 
		<artifactId>commons-collections</artifactId> 
		<version>3.2.1</version>
	</dependency>
	<dependency> 
		<groupId>org.apache.commons</groupId>
		<artifactId>commons-lang3</artifactId>
		<version>3.1</version>
	</dependency>
	<dependency> 
		<groupId>junit</groupId> 
		<artifactId>junit</artifactId> 
		<version>4.8.2</version>
		<scope>test</scope> 
	</dependency>

If you are not using maven you can download the jars from apache site as well. The Urls are as follows:
 common collection's URL:
 http://commons.apache.org/proper/commons-collections/download_collections.cgi
 
 common lang 's URL:
 http://commons.apache.org/proper/commons-lang/download_lang.cgi
 
 https://github.com/junit-team/junit/wiki/Download-and-Install
