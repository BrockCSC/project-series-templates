from PIL import Image
import ImgOps as imgOps
import Filters as filters
import copy
from math import *
import numpy
from HelpMenu import *

bit_per_col = 5
input_root = "Input/"
output_root = "Output/"
col_type = "c"
image_name = ""
image_ext = ""
output_name = ""

# colours_6_bit = []
#
#
#



display_help = True;

while True:

	if display_help:
		print_controls()
		display_help = False

	print ("Enter Command...\n")
	command = raw_input()
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
		else:
			img_list = imgOps.set_up_image(input_root, image_name, image_ext)
			print ("Converting Image")
			new_img = filters.pixelate(img_list, int(command_parts[1]), command_parts[2])
			imgOps.save_image(new_img, output_root, output_name)
			print ("Image Saved")





#new_img = filters.pixelate(img_list, 15, filters.mean_col)#filters.convert_n_bit_image(img_list, bit_per_col, col_type)

#imgOps.save_image(new_img, output_root + image_name +"-"+ (str(bit_per_col*3) if col_type == "c" else str(bit_per_col)) + "bit" + ("-gray" if col_type == "g" else "-full"))

#
# print("Program Finished")