using MakeLessString;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace MakeLessStringTest
{
    /// <summary>
    ///MakeLessStringTest のテスト クラスです。すべての
    ///MakeLessStringTest 単体テストをここに含めます
    ///</summary>
    [TestClass()]
    public class MakeLessStringTest
    {
        private TestContext testContextInstance;

        /// <summary>
        ///現在のテストの実行についての情報および機能を
        ///提供するテスト コンテキストを取得または設定します。
        ///</summary>
        public TestContext TestContext
        {
            get
            {
                return testContextInstance;
            }
            set
            {
                testContextInstance = value;
            }
        }

        #region 追加のテスト属性
        // 
        //テストを作成するときに、次の追加属性を使用することができます:
        //
        //クラスの最初のテストを実行する前にコードを実行するには、ClassInitialize を使用
        //[ClassInitialize()]
        //public static void MyClassInitialize(TestContext testContext)
        //{
        //}
        //
        //クラスのすべてのテストを実行した後にコードを実行するには、ClassCleanup を使用
        //[ClassCleanup()]
        //public static void MyClassCleanup()
        //{
        //}
        //
        //各テストを実行する前にコードを実行するには、TestInitialize を使用
        //[TestInitialize()]
        //public void MyTestInitialize()
        //{
        //}
        //
        //各テストを実行した後にコードを実行するには、TestCleanup を使用
        //[TestCleanup()]
        //public void MyTestCleanup()
        //{
        //}
        //
        #endregion

        /// <summary>
        ///solve のテスト
        ///</summary>
        [TestMethod()]
        [DeploymentItem("MakeLessString.exe")]
        public void solveTest()
        {
            Solver target = new Solver();
            string question = "AABBCBBBAA";
            string expected = "AAAABBBBBC";
            string actual;
            actual = target.solve(question);
            Assert.AreEqual(expected, actual);

            question = "ABCA";
            expected = "AABC";
            actual = target.solve(question);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        ///getLesserString のテスト
        ///</summary>
        [TestMethod()]
        [DeploymentItem("MakeLessString.exe")]
        public void getLesserStringTest()
        {
            Solver_Accessor target = new Solver_Accessor();
            string str = "ABAA";
            string expected = "AABA";
            string actual;
            actual = target.getLesserString(str);
            Assert.AreEqual(expected, actual);

            str = "AABA";
            expected = "AABA";
            actual = target.getLesserString(str);
            Assert.AreEqual(expected, actual);
        }
    }
}
