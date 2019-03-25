#Youtube to Mp3 Converter Script 


from __future__ import unicode_literals
import youtube_dl
import os
from sys import argv

# download data and config

download_option = {
	'format': 'bestaudio/best',
	'outtmpl':'%(title)s.%(ext)s',
	'nocheckcertificate': True,
	'postprocessors':[{
		'key':'FFmpegExtractAudio',
		'preferredcodec':'mp3',
		'preferredquality':'320',
		}],
	}
#Song Directory
if not os.path.exists('songs'):
	os.mkdir('songs')
else:
	os.chdir('songs')
# Download Songs
with youtube_dl.YoutubeDL(download_option) as dl:
	with open(argv[1], 'r') as f:
		for song_url in f:
			dl.download([song_url])