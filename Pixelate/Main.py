
# Import allows us to use the other classes that we made
import ImgOps as imgOps # Does the image operations like loading and saving the image
import Filters as filters # Holds the funtions for the different filters implemented
from HelpMenu import * # contains the text for the help menu including a separate help for functions

from math import *


bit_per_col = 5
input_root = "Input/"
output_root = "Output/"
col_type = "c"
image_name = ""
image_ext = ""
output_name = ""




display_help = True;

while True:

	if display_help:
		print_controls()
		display_help = False

	print ("Enter Command...\n")
	command = input()
	print ("\n")
	command_parts = command.split(" ")
	command_parts[0] = command_parts[0].lower()

	if ((command_parts[0] == "exit") | (command_parts[0] == "quit")):
		break
	
	elif (command_parts[0] == "image"):
		name_parts = command_parts[1].split(".")
		image_ext = "." + name_parts[-1]
		del name_parts[-1]
		image_name = ".".join(name_parts)
		output_name = "new_" + image_name
		print ("Input image set to: " + image_name + image_ext)
	
	elif (command_parts[0] == "in_dir"):
		del command_parts[0]
		input_root = " ".join(command_parts) + "/"
		print ("Input directory set to: " + input_root)
	
	elif (command_parts[0] == "out_name"):
		del command_parts[0]
		output_name = " ".join(command_parts)
		print("Output name set to: " + output_name)
	
	elif (command_parts[0] == "out_dir"):
		del command_parts[0]
		output_root = " ".join(command_parts) + "/"
		print ("Output directory set to: " + output_root)

	elif (command_parts[0] == "pixelate"):
		if (command_parts[1].lower() == "help"):
			pixelate_help()
		elif (len(command_parts) != 3):
			print("You have entered an invalid number of parameters. Type \'pixelate help\' for more details")
		else:
			img_list = imgOps.set_up_image(input_root, image_name, image_ext)
			print ("Converting Image")
			new_img = filters.pixelate(img_list, int(command_parts[1]), command_parts[2])
			imgOps.save_image(new_img, output_root+output_name)
			print ("Image Saved")

	elif (command_parts[0] == "colconvert"):
		if (command_parts[1].lower() == "help"):
			col_convert_help()
		elif (len(command_parts) != 3):
			print ("You have entered an invalid number of parameters. Type \'colconvert help\' for more details")
		else:
			img_list = imgOps.set_up_image(input_root, image_name, image_ext)
			print ("Converting Image")
			new_img = filters.convert_n_bit_image (img_list, int(command_parts[1]), command_parts[2])
			imgOps.save_image(new_img, output_root+output_name)
			print ("Image Saved")
