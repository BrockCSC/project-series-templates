from PIL import Image
import ImgOps as imgOps
import Filters as filters
import copy
from math import *
#import numpy

bit_per_col = 5
input_root = "Input/"
output_root = "Output/"
col_type = "c"
image_name = "puppy2"
image_ext = ".jpg"

# colours_6_bit = []
#
#
#

image = Image.open(input_root+image_name+image_ext)

img_list = imgOps.convert_img_to_list(image)

print ("Converting Image")
new_img = filters.pixelate(img_list, 5, filters.mean_col)#filters.convert_n_bit_image(img_list, bit_per_col, col_type)

imgOps.save_image(new_img, output_root + image_name +"-"+ (str(bit_per_col*3) if col_type == "c" else str(bit_per_col)) + "bit" + ("-gray" if col_type == "g" else "-full"))
print ("Image Saved")
#
# print("Program Finished")
