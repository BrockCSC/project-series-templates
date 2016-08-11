# Mario Mashup platformer

## Controls
WASD for arrow keys, '.' is b (running) '/' is a (jumping) (this is closer to the layout of the nes controller.

## Current Features
  - Collision Detection
  - Mario Sprite is animated and moving
  - Scrolling Camera

## Planned Features
  - Multiple levels
  - Ability to progress between levels smoothly

## Challenges
Easy
  - Manually make a couple of maps

Medium
  - Make a map previewer
  - Add in new blocks or sprites

Hard
  - Make a map creator (Blocks displayed, user can place them with mouse and map will be generated after)
  - Add new physics to ertain blocks

## Extra Information
### Maps
Maps start with a pair of numbers that specify the size of the map, rows, then columns. The rest of the file is tokens, the tokens are 3+ characters.

If the token starts with s it is a _special_ tile, these are generated from the tile factory. The next number in the token specifies the layer, followed by the special tile number.

If the token starts with a t, it is a regular tile. The second number in the token specifies layer, followed by the special tile number.

If the token starts with a h, it is a hero, you may specifiy the layer, and the last number is ignored.

### Sprites
There are two image loaders, static and animation based. The animation based loader loads images from the middle out giving frame numbers from 0 -> x. The name of the loaded images are `<prefix>-<row>-<l or r>` where l and r are the left and right facing sprites respectively.

The static loader loads each image in, in a row major order, so the first image is the top left, the second image is the image to the right of the first. Retrieve the image by requesting `<prefix>-row-col` for simplicity.

Images are requested from the Graphics Manager by requesting an instance with `getInstance()` then retrieving the image with `retrieveImage(String img)`.

Images loaded into the graphics managers are specified in settings.txt in sprite/ 
