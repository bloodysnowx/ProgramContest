using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace MakeLessString
{
    class Solver
    {
        static void Main(string[] args)
        {
        }

        public string solve(string question)
        {
            string answer = "";
            while (question.Length > 0)
            {
                question = getLesserString(question);
                answer += question[0];
                question = question.Substring(1);
            }
            return answer;
        }

        /** <summary>自身と自身を反転した文字列とのうち、小さい順序の文字列を返す</summary> */
        private string getLesserString(string str)
        {
            char[] revchars = str.ToCharArray();
            Array.Reverse(revchars);
            string revstr = new string(revchars);
            return (str.CompareTo(revstr) < 0) ? str : revstr;
        }
    }
}
