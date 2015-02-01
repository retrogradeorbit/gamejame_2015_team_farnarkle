var SeedableRandom={};

/**
	@class A fast, deterministic, seedable random number generator.
	@description Unlike the native random number generator built into most browsers, this one is deterministic, and so it will produce the same sequence of outputs each time it is given the same seed. By default it is seeded with the current time, which means the output is effectively non-deterministic. To make the output deterministic (e.g. the same each time) you should seed it with your own number. This code is based on George Marsaglia's MWC algorithm from the v8 Javascript engine.
	@param seed is an optional number to set the initial seed.
*/

SeedableRandom.random = function(seed) {};
