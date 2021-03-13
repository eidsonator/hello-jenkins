#! /bin/bash

file=README.md

olddir=$(pwd)

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

cd $DIR/.. || exit

if [ -f "$file" ]; then
    echo "$file exists"
fi

cd $olddir || exit

exit 1