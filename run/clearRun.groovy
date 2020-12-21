@Grapes([
    @Grab(group='org.apache.poi', module='poi', version='4.1.2'),
    @Grab(group='org.apache.poi', module='poi-ooxml', version='4.1.2'),
    @Grab(group='org.apache.poi', module='poi-scratchpad', version='4.1.2'),
    @Grab(group='org.apache.poi', module='ooxml-schemas', version='1.4'),
])

def resourceAsStream = new File('.','clearRun.docx').newInputStream()
def xwpfDocument = new org.apache.poi.xwpf.usermodel.XWPFDocument(resourceAsStream)
def nameParagraph = xwpfDocument.paragraphs[0]

def run = nameParagraph.runs[0]

def lastIndexOfTArray = run.CTR.sizeOfTArray() - 1

for (i in 0..lastIndexOfTArray) {
    run.setText("", i)
}

assert nameParagraph.runs[0].text() == ""
