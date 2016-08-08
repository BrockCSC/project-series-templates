import copy
from math import *
import array

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

def gen_n_bit_colours(n, col_type):
    print ("Generating " + (str(n*3) if col_type == "c" else str(n)) + "-bit color palette")
    cols = []
    if (col_type == "g"):
        for i in range (0, int(pow(2, n))):
            shade = int((i/pow(2, n)) * 255)
            cols.append((shade, shade, shade))
        return cols
    elif (col_type == "c"):
        for r in range (0, n+1):
            for g in range(0, n+1):
                for b in range(0, n+1):
                    cols.append((int(255*(r/n)), int(255*(g/n)), int(255*(b/n))))
        return cols

def convert_n_bit_image(img_list, bit_color, col_type):
    colours_3_bit = gen_n_bit_colours(bit_color, col_type)
    #values = convert_list_to_rgb(img_list)
    nvals = copy.deepcopy(img_list)
    for i in range(0, len(img_list)):
        for j in range(0, len(img_list[i])):
            #print(values[i][j])
            nvals[i][j] = get_closest_col(img_list[i][j], colours_3_bit)
            #print(nvals[i][j])
    return nvals

def mean_col(cols):
    r_sum, g_sum, b_sum = 0, 0, 0

    for i in range(0, len(cols)):
        r_sum += cols[i][0]
        g_sum += cols[i][1]
        b_sum += cols[i][2]

    r_avg, g_avg, b_avg = r_sum/len(cols), g_sum/len(cols), b_sum/len(cols)
    return (r_avg, g_avg, b_avg)

def pixelate(img_list, pixel_size, col_type):
    square_cols = []
    nvals = []
    pixel_height, pixel_width = int(ceil(len(img_list[0])/pixel_size)), int(ceil(len(img_list)/pixel_size))

    nvals = copy.deepcopy(img_list)

    print ("height: " + str(len(img_list[0])) + "\twidth: " + str(len(img_list)))
    for i in range (0, pixel_height + 1):
        for j in range(0, pixel_width + 1):
            square_cols = []
            for x in range (0, pixel_size):
                for y in range (0, pixel_size):
                    if (((i*pixel_size) + x < len(img_list)) & ((j*pixel_size) + y < len(img_list[0]))):
                        square_cols.append(img_list[(i*pixel_size) + x][(j*pixel_size) + y])
            if (len(square_cols) > 0):
                max_col = col_type(square_cols)
                for x in range(0, pixel_size):
                    for y in range(0, pixel_size):
                        if (((i*pixel_size) + x < len(img_list)) & ((j*pixel_size) + y < len(img_list[0]))):
                            nvals[(i*pixel_size)+x][(j*pixel_size)+y] = max_col
    return nvals


def grayscale(img_list):
    print("not yet implemented")

