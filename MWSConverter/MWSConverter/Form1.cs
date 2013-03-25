using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace MWSConverter
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string originalText = textBox1.Text;
            string[] delimiter = { "Sideboard" };
            string[] parts = originalText.Split(delimiter, StringSplitOptions.None);
            if (parts.Length != 2)
                textBox2.Text = originalText;
            else
            {
                string mainText = parts[0];
                System.Text.RegularExpressions.Regex regex = new System.Text.RegularExpressions.Regex("([1-4])");
                string sideText = regex.Replace(parts[1], "SB: $1");
                textBox2.Text = mainText + sideText;
            }

            Clipboard.SetText(textBox2.Text);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            if (Clipboard.ContainsText())
            {
                textBox1.Text = Clipboard.GetText();
            }
        }
    }
}
