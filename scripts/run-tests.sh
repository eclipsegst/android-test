
# Example
# ./scripts/run-tests.sh Development
# ./scripts/run-tests.sh Full

FLAVOR="$1"
if [[ -z "$FLAVOR" ]]; then
echo "No flavor specified, use Development flavor"
FLAVOR=Development
fi

./gradlew lint${FLAVOR}Debug test${FLAVOR}DebugUnitTest connected${FLAVOR}DebugAndroidTest
