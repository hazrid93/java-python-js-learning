### Sections

:boom: [core-python-syntax](./core-python) <br/>

:boom: [metatrader-machine-learning](./metatrader)
  - [Type-A Gen-1](./metatrader/gen1)

### Virtual env setup (python default)
- to create virtual environment to avoid installing dependency on global
> python -m venv env // venv is the environment name

- install from requirement file (like maven dependencies or js package.json)
> python -m pip install -r requirements.txt

- export current setup into requirement file
> python -m pip freeze > requirements.txt

- to start virtual environtment , in project directory runs
> .\env\Scripts\activate
  to exit runs (do pip install etc inside the new shell)
> deactive 

- show python pip package location
> pip list -v

- installing a package
> pip install <package>

Note: official note at : https://docs.python.org/3/tutorial/venv.html


 ### (USE THIS) Pipenv setup (similar to** node package manager)
 - change pipenv python version
 > 'remove Pipfile && Pipfile.lock'
 > python -m pipenv --rm
 > python -m pipenv --python <version>

 - [important] note that tensorflow support python 3.7~3.9 only 
 > our stack would be, python : 3.9.9, tensorflow 2.7, CUDA : 11.2.x and cuDNN: 8.1.x

- installing CUDA driver to allow tensorflow 2.7 to use GPU (guide [from](http://www.mysmu.edu/faculty/jwwang/post/install-gpu-support-to-tensoflow-on-windows/) )/ or https://www.tensorflow.org/install/gpu
  * install visual studio community [link](https://visualstudio.microsoft.com/thank-you-downloading-visual-studio/?sku=community&rel=17)
  * python -c "import tensorflow as tf;print(tf.__version__)" # to check tensorflow version
  * https://www.tensorflow.org/install/source_windows#gpu # to check required cuda version here
  * for TS 2.7 need:  CUDA and cuDNN versions are 11.2 and 8.1
  * download CUDA at: https://developer.nvidia.com/cuda-toolkit-archive
  * install cuDNN: https://docs.nvidia.com/deeplearning/cudnn/install-guide/index.html (check prerequisite and install the right version in this case 8.1)
  * for cuDNN After download, unzip the file and copy the following files into the CUDA Toolkit directory.
    ```
    Copy \cuda\bin\cudnn*.dll to C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.2\bin.
    Copy \cuda\include\cudnn*.h to C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.2\include.
    Copy \cuda\lib\x64\cudnn*.lib to C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.2\lib\x64.
    ```
    * Add the CUDA®, CUPTI, and cuDNN installation directories to the windows environmental variable (under Path in system variable). For example, if the CUDA® Toolkit is installed to C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.0 and cuDNN to C:\tools\cuda
    ```
    C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.x\bin
    C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.x\extras\CUPTI\lib64
    C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.x\include
    C:\Program Files\NVIDIA GPU Computing Toolkit\CUDA\v11.2\libnvvp
    C:\tools\cuda\bin;%PATH%
    ```
  * To check whether TensorFlow has access to the GPU support, open Python console (through Anaconda Powershell Prompt for my case), and then run the following code one line at a time:
    ```
    import tensorflow as tf: launch the TensorFlow
    print(tf.test.is_built_with_cuda()): Returns whether TensorFlow was built with CUDA (GPU) support. True if CUDA is installed properly.
    print(tf.config.list_physical_devices('GPU')): Return a list of physical GPU devices visible to the TensoFlow. The output will show all physical GUP devices, starting from index 0.
    ```
  * Alternatively, run the following code directly in the command shell:
    ```
    python -c "import tensorflow as tf;print(tf.test.is_built_with_cuda());print(tf.config.list_physical_devices('GPU'))"
    ```

 - install pipenv in global (similar to npm in nodejs, this is alternative to venv python feature)
> pip install --user pipenv

- instantiate pipenv in new project
> python -m pipenv --python <python_version> // this will generate Pipfile in current project
- selecting virtual environment python
> when running or debugging python script select the virtual python interpreter at bottom left of VSCode

- make sure there is Pipfile.lock (similar to package.lock in node),
  inside '[script]' we can define our own run script like package.json
```
// example of Pipfile.lock
[[source]]
url = "https://pypi.org/simple"
verify_ssl = true
name = "pypi"

[packages]
flask = "*"
simplejson = "*"
python-dotenv = "*"

[dev-packages]
watchdog = "*"

[scripts]
start = "python -m flask run"

[requires]
python_version = "3.9"
```
  
- to run py script with virtual env
> pipenv run python server.py

- install new package into local virtual env ( this will create Pipfile)
> pipenv install <package> // similar to npm install , it will generate Pipfile if it doesnt exist

- help
> pipenv install -h

- custom run script
```
 // in Piplock
[scripts]
start = "python -m flask run"

// and then to run
pipenv run start
```

- pipenv install format for versioning selection
```
 pipenv install "requests>=1.4"   # will install a version equal or larger than 1.4.0 <br/>
 pipenv install "requests<=2.13"  # will install a version equal or lower than 2.13.0 <br/>
 pipenv install "requests>2.19"   # will install 2.19.1 but not 2.19.0 <br/>
```

- to run py script with virtual env
> pipenv run python server.py

- show python pip package location
 > pipenv --venv

 Note: official note at: https://pipenv.pypa.io/en/latest/basics/#importing-from-requirements-txt
