import re
# generate and test regex string at https://regex101.com/

txt = "raining in kuala lumpur"
x = re.findall("in",txt)
print(x)