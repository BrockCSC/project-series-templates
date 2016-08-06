from PIL import Image
import copy
import colorsys
from math import *
# Convert the passed in image to a list of colours
def convert_img_to_list(img):
    # Converts to RGB image
    rgb_img = img.convert('RGB')
    # Create empty list
    rgb_vals = []
    # Loop through the height of the image
    for j in range(0, rgb_img.size[1]):
        # Add an empty list at for each row
        rgb_vals.append([])
        for i in range(0, rgb_img.size[0]):
            # Add the pixel values to the list
            rgb_vals[j].append(rgb_img.getpixel((i, j)))
            #print(rgb_img.getpixel((i, j)))
    return rgb_vals

# Saves the image
def save_image(values, name):
    # Creates a new image with the same size as the old one
    image = Image.new('RGB', (len(values[0]), len(values)))
    # DOES SOMETHING. i STILL NEED TO FIGURE OUT WHAT
    values = [item for sublist in values for item in sublist]
    # Writes the data to the new image
    image.putdata(values)
    # Saves the image
    image.save(name+'.png')


def convert_list_to_rgb(values):
    new_values = copy.deepcopy(values)
    for i in range(0, len(values)):
        for j in range(0, len(values[i])):
            a = new_values[i][j]
            new_values[i][j] = colorsys.hsv_to_rgb(float(values[i][j][0] / 360),
                                                   float(values[i][j][1]),
                                                   float(values[i][j][2]))
            x = new_values[i][j]
            new_values[i][j] = (
            int(new_values[i][j][0] * 255), int(new_values[i][j][1] * 255), int(new_values[i][j][2] * 255))

    return new_values

def get_colour_distance(col1, col2):
    #print("not implemented")
    return sqrt(pow((col1[0]-col2[0]),2) + pow((col1[1]-col2[1]),2) + pow((col1[2]-col2[2]),2))

def get_closest_col(col1, col_list):
   # print("Not implemented")
    closest_col = ()
    best_dist = -1
    for i in range(0, len(col_list)):
        cur_dist = get_colour_distance(col1, col_list[i])
        if ((best_dist == -1) | (best_dist > cur_dist)):
            best_dist = cur_dist
            closest_col = col_list[i]
            #print("Best Distance Updated")
    return closest_col

def get_n_bit_colours(n):
    cols = []
    if (n % 3 != 0):
        n = int(ceil(n/3.0) * 3)
    print(n)
    for r in range (0, int(n/3)+1):
        for g in range(0, int(n/3)+1):
            for b in range(0, int(n/3)+1):
                cols.append((int(255*(r/(n/3))), int(255*(g/(n/3))), int(255*(b/(n/3)))))
    return cols




colours_3_bit = get_n_bit_colours(3)
# colours_6_bit = []
#
#
#
image = Image.open("char.jpg")

img_list = convert_img_to_list(image)

#values = convert_list_to_rgb(img_list)
nvals = copy.deepcopy(img_list)

for i in range(0, len(img_list)):
    for j in range(0, len(img_list[i])):
        #print(values[i][j])
        nvals[i][j] = get_closest_col(img_list[i][j], colours_3_bit)
        #print(nvals[i][j])
save_image(nvals, "char-3bit")
#
# print("Program Finished")