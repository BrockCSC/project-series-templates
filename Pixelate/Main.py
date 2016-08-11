#    Pixelate - A basic image manipulation program created for
#    the BrockCSC Project Series
#    Copyright (C) 2016  Adam Balint
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.

#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.

#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.



# The main control system of the program

# Import allows us to use the other classes that we made
import ImgOps as imgOps # Does the image operations like loading and saving the image
import Filters as filters # Holds the funtions for the different filters implemented
from HelpMenu import * # contains the text for the help menu including a separate help for functions


# Basic image locator variables
input_root = "Input/"
output_root = "Output/"
image_name = ""
image_ext = ""
output_name = ""

# set so that the help displays initially
display_help = True;

# Loop forever
while True:

	# Display the help menu
	if display_help:
		print_controls()
		display_help = False

	# Wait for user input
	print ("Enter Command...\n")
	command = input()
	print ("\n")
	command_parts = command.split(" ")
	command_parts[0] = command_parts[0].lower()

	# If user wants to quit then break out of loop
	if ((command_parts[0] == "exit") | (command_parts[0] == "quit")):
		break
	
	# Set input image name
	elif (command_parts[0] == "image"):
		name_parts = command_parts[1].split(".")
		image_ext = "." + name_parts[-1]
		del name_parts[-1]
		image_name = ".".join(name_parts)
		output_name = "new_" + image_name
		print ("Input image set to: " + image_name + image_ext)
	
	# Set input root directory
	elif (command_parts[0] == "in_dir"):
		del command_parts[0]
		input_root = " ".join(command_parts) + "/"
		print ("Input directory set to: " + input_root)
	
	# Set the output name
	elif (command_parts[0] == "out_name"):
		del command_parts[0]
		output_name = " ".join(command_parts)
		print("Output name set to: " + output_name)
	
	# Set output root directory
	elif (command_parts[0] == "out_dir"):
		del command_parts[0]
		output_root = " ".join(command_parts) + "/"
		print ("Output directory set to: " + output_root)

	# Pixelate connand options and running the program
	elif (command_parts[0] == "pixelate"):
		if (command_parts[1].lower() == "help"):
			pixelate_help()
		elif (len(command_parts) != 3):
			print("You have entered an invalid number of parameters. Type \'pixelate help\' for more details")
		else:
			img_list = imgOps.set_up_image(input_root, image_name, image_ext)
			new_img = filters.pixelate(img_list, int(command_parts[1]), command_parts[2])
			imgOps.save_image(new_img, output_root+output_name)

	# Color palette conversion command options and running the program
	elif (command_parts[0] == "colconvert"):
		if (command_parts[1].lower() == "help"):
			col_convert_help()
		elif (len(command_parts) != 3):
			print ("You have entered an invalid number of parameters. Type \'colconvert help\' for more details")
		else:
			img_list = imgOps.set_up_image(input_root, image_name, image_ext)
			new_img = filters.convert_n_bit_image (img_list, int(command_parts[1]), command_parts[2])
			imgOps.save_image(new_img, output_root+output_name)
