class World:
    name = ""
    __constantC = "constant"

    def __init__(self, name):
        self.name = name

    #def detail(self, name):
     #   print("just detail with para")

    def detail(self):
        print("just detail without para")


if __name__ == '__main__':
    World.__init__(str("1"))
