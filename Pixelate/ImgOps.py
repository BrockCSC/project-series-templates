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
    print ("Saving Image as " + name)
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