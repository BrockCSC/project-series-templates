def print_controls():
	print ("\n\n\n\n\n")
	print ("Function \t\t Command \t\t\t Example")
	print ("-------------------------------------------------------------------------------")
	print ("Quit Program \t\t quit or exit")
	print ("Setting Image \t\t image name.extension \t\t image puppy.jpg")
	print ("Setting Save Name \t out_name file_name \t\t out_name new_picture")
	print ("Set Input Directory \t in_dir directory_path \t\t in_dir Images")
	print ("Set Output Directory \t out_dir directory_path \t out_dir Output")
	print ("\n------------------------------Programs-----------------------------------------")
	print ("Function \t\t\t Command")
	print ("-------------------------------------------------------------------------------")
	print ("Pixelate image \t\t pixelate pixel_size color_selection_method")
	print ("Convert color palette \t colconvert num_bits color_type")
	print ("\n\n")

def pixelate_help():
	print ("Input \t\t\t pixelate pixel_size color_selection_method")
	print ("pixel_size \t\t integer value (ex. 5) \n \t\t\t makes pixel to be that size square (ex. 5x5)")
	print ("color_selection_method \t max, min, mean_col \n \t\t\t selects the max, min or average color from the group")
	print("\n")

def col_convert_help():
	print ("Input \t\t\t colconvert num_bits color_type")
	print ("num_bits \t\t integer value (ex. 5) \n \t\t\t Number of bits per color channel (ex. (2^5)^3 for \n \t\t\t 5 bits giving a 32,768-color palette)")
	print ("color_selection_method \t g (grayscale) or c (full color)")
	print("\n")