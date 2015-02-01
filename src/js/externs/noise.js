// This file originally from here:
// https://gist.github.com/304522
//
// There appears to be no license attached, so I am assuming public domain.
// I have added inline documentation.

var noise = {};

/**
	@class Classical Perlin noise implementation.
	@description Generates smooth Perlin noise. Ported from Stefan Gustavson's Java implementation by Sean McCullough. Original source here: https://gist.github.com/304522
	@param r is optionally a random number generator which has a .random() method (such as jsGameSoup's own SeedableRandom())
*/

// Ported from Stefan Gustavson's java implementation
// http://staffwww.itn.liu.se/~stegu/simplexnoise/simplexnoise.pdf
// Read Stefan's excellent paper for details on how this code works.
//
// Sean McCullough banksean@gmail.com

noise.PerlinNoise = function(r) {};
noise.PerlinNoise.prototype.dot = function(g, x, y, z) {};
noise.PerlinNoise.prototype.mix = function(a, b, t) {};
noise.PerlinNoise.prototype.fade = function(t) {};

/**
	@method takes a position in 3d space.
	@returns a number between 0 and 1.
*/
// Classic Perlin noise, 3D version
noise.PerlinNoise.prototype.noise = function(x, y, z) {};


/**
	@class Ken Perlin's simplex noise implementation.
	@description Generates smooth Simplex noise. Ported from Stefan Gustavson's Java implementation by Sean McCullough. Original source here: https://gist.github.com/304522
	@param r is optionally a random number generator which has a .random() method (such as jsGameSoup's own SeedableRandom()
*/
noise.SimplexNoise = function(r) {};
noise.SimplexNoise.prototype.dot = function(g, x, y) {};

/**
	@method
	@description 2d Simplex noise method takes a position in 2d space.
	@returns a number between 0 and 1.
*/
noise.SimplexNoise.prototype.noise = function(xin, yin) {};

/**
	@method
	@description takes a position in 3d space.
	@returns a number between 0 and 1.
*/
noise.SimplexNoise.prototype.noise3d = function(xin, yin, zin) {};
