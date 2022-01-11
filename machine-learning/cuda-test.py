# To verify Tensorflow are able to use GPU properly

import tensorflow as tf

print(tf.test.is_built_with_cuda()) # should print 'True' without any error

print(tf.config.list_physical_devices('GPU'))
