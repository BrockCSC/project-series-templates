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



# Defines the text that is written when the help menu is called

# Overview control commands
def print_controls():
	print ("\n\n\n\n\n")
	print ("Function \t\t Command \t\t\t Example")
	print ("-------------------------------------------------------------------------------")
	print ("Quit Program \t\t quit or exit")
	print ("Setting Image \t\t image name.extension \t\t image puppy.png")
	print ("Setting Save Name \t out_name file_name \t\t out_name new_picture")
	print ("Set Input Directory \t in_dir directory_path \t\t in_dir Images")
	print ("Set Output Directory \t out_dir directory_path \t out_dir Output")
	print ("\n------------------------------Programs-----------------------------------------")
	print ("Function \t\t\t Command")
	print ("-------------------------------------------------------------------------------")
	print ("Pixelate image \t\t pixelate pixel_size color_selection_method")
	print ("Convert color palette \t colconvert num_bits color_type")
	print ("\n\n")

# Pixelate commands
def pixelate_help():
	print ("Input \t\t\t pixelate pixel_size color_selection_method")
	print ("pixel_size \t\t integer value (ex. 5) \n \t\t\t makes pixel to be that size square (ex. 5x5)")
	print ("color_selection_method \t max, min, mean_col \n \t\t\t selects the max, min or average color from the group")
	print("\n")

# Color palette conversion commands
def col_convert_help():
	print ("Input \t\t\t colconvert num_bits color_type")
	print ("num_bits \t\t integer value (ex. 5) \n \t\t\t Number of bits per color channel (ex. (2^5)^3 for \n \t\t\t 5 bits giving a 32,768-color palette)")
	print ("color_selection_method \t g (grayscale) or c (full color)")
	print("\n")
