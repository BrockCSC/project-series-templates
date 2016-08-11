# The class that stores all of the filters and filter operations


import copy # allows us to easily copy arrays
from math import * # imports math library
#import array

# Returns the distance between the 2 colors
def get_color_distance(col1, col2):
    #print("not implemented")
    return sqrt(pow((col1[0]-col2[0]),2) + pow((col1[1]-col2[1]),2) + pow((col1[2]-col2[2]),2))

# gets the closest color to a color from a set of different colors
def get_closest_col(col1, col_list):
   # print("Not implemented")
    closest_col = ()
    best_dist = -1
    for i in range(0, len(col_list)):
        cur_dist = get_color_distance(col1, col_list[i])
        if ((best_dist == -1) | (best_dist > cur_dist)):
            best_dist = cur_dist
            closest_col = col_list[i]
            #print("Best Distance Updated")
    return closest_col

# Generates a color palette using n bits for each color channel
# Includes grayscale, however grayscale at a large bit value is inefficient
def gen_n_bit_colours(n, col_type):
    print ("Generating " + (str(n*3) if col_type == "c" else str(n)) + "-bit color palette")
    cols = []

    # If grayscale then loop through 2^n (number of bits times) times and set the color 
    # as a fraction for the i/(2^n) * 255 to get an RGB value. Set all the channels to the
    # same color
    if (col_type == "g"):
        for i in range (0, int(pow(2, n))):
            shade = int((i/pow(2, n)) * 255)
            cols.append((shade, shade, shade))
        return cols

    # If color, then loop through each channel separately and do similar as above to get the
    # RGB color value
    elif (col_type == "c"):
        for r in range (0, n+1):
            for g in range(0, n+1):
                for b in range(0, n+1):
                    cols.append((int(255*(r/n)), int(255*(g/n)), int(255*(b/n))))
        return cols

# Converts the color palette of an image
def convert_n_bit_image(img_list, bit_color, col_type):
    colours_n_bit = gen_n_bit_colours(bit_color, col_type)
    print ("Converting Image")
    #values = convert_list_to_rgb(img_list)
    nvals = copy.deepcopy(img_list)
    for i in range(0, len(img_list)):
        for j in range(0, len(img_list[i])):
            #print(values[i][j])
            nvals[i][j] = get_closest_col(img_list[i][j], colours_n_bit)
            #print(nvals[i][j])
    return nvals

# Returns the mean color of the colors in a list by averaging out each channel
def mean_col(cols):
    r_sum, g_sum, b_sum = 0, 0, 0

    for i in range(0, len(cols)):
        r_sum += cols[i][0]
        g_sum += cols[i][1]
        b_sum += cols[i][2]

    r_avg, g_avg, b_avg = r_sum/len(cols), g_sum/len(cols), b_sum/len(cols)
    return (r_avg, g_avg, b_avg)

# Pixelates an image
def pixelate(img_list, pixel_size, col_type):

    # Set function as variable
    if (col_type.lower() == "max"):
        col_type = max
    elif (col_type.lower() == "min"):
        col_type = min
    else:
        col_type = mean_col
    
    square_cols = []
    nvals = []
    pixel_height, pixel_width = int(ceil(len(img_list[0])/pixel_size)), int(ceil(len(img_list)/pixel_size))

    # Create a copy to work on
    nvals = copy.deepcopy(img_list)
    print ("Converting Image")
    print ("height: " + str(len(img_list[0])) + "\twidth: " + str(len(img_list)))

    # loop through all the pixels that will be in the new image
    # ex. 100 x 100 original image with a pixel size of 5 would loop 20(for i) and 20(for j) times
    for i in range (0, pixel_height + 1):
        for j in range(0, pixel_width + 1):
            square_cols = []

            # For each pixel group (the pixel at (i,j) in the new image)
            # loop pixel_size times in the old image using the mapping of the pixel in the new image
            # to the starting pixel in the old image as a starting point
            # ex. pixel 1,2 in the new image with a pixel size of 5 would contain pixels
            # in column 10-14 (5 pixels starting at 2(row)*5(pixel_size))and rows 5-9
            # using the same calculation as above
            for x in range (0, pixel_size):
                for y in range (0, pixel_size):
                    if (((i*pixel_size) + x < len(img_list)) & ((j*pixel_size) + y < len(img_list[0]))):
                        square_cols.append(img_list[(i*pixel_size) + x][(j*pixel_size) + y])

            # If for some reason there are no pixels in the array then skip
            # otherwiae get the new color and fill in pixel_size by pixel_size number of pixels with that color
            # This way the image stays the same size while still being pixelated
            if (len(square_cols) > 0):
                new_col = col_type(square_cols)
                for x in range(0, pixel_size):
                    for y in range(0, pixel_size):
                        if (((i*pixel_size) + x < len(img_list)) & ((j*pixel_size) + y < len(img_list[0]))):
                            nvals[(i*pixel_size)+x][(j*pixel_size)+y] = new_col
    return nvals


# Will Implement the more efficient grayscale
def grayscale(img_list):
    print("not yet implemented")

